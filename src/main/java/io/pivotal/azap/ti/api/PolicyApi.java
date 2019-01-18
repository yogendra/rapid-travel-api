package io.pivotal.azap.ti.api;

import static io.pivotal.azap.ti.PolicyStatus.APPROVED;
import static io.pivotal.azap.ti.api.ApiException.invalidRequest;
import static io.pivotal.azap.ti.db.PolicyContractDetail.fromMap;

import io.pivotal.azap.ti.db.Customer;
import io.pivotal.azap.ti.db.CustomerRepository;
import io.pivotal.azap.ti.db.PolicyContract;
import io.pivotal.azap.ti.db.PolicyContractRepository;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/policies")
@Slf4j
public class PolicyApi {

  private MapperFacade mapperFacade;

  private PolicyContractRepository contracts;
  private CustomerRepository customers;
  private List<Product> products;

  @Autowired
  public PolicyApi(MapperFacade mapperFacade,
      PolicyContractRepository policyContractRepository,
      CustomerRepository customers,
      List<Product> products) {
    this.mapperFacade = mapperFacade;
    this.contracts = policyContractRepository;
    this.customers = customers;
    this.products = products;
  }

  @GetMapping("/{id}")
  public Policy get(@PathVariable("id") Long id) {
    return contracts.findById(id).map(x -> {
      return Policy.builder()
          .id(id)
          .coverage(x.getCoverage())
          .coverageEnd(x.getCoverEnd())
          .coverageStart(x.getCoverStart())
          .name(getProduct(x.getProductCode()).getName())
          .premium(x.getPremium())
          .premiumFrequency(x.getPremiumFrequency())
          .customerName(x.getCustomer().getName())
          .customerEmail(x.getCustomer().getEmail())
          .customerPhoneNumber(x.getCustomer().getPhoneNumber())
          .productCode(x.getProductCode())
          .status(x.getStatus())
          .transactionReference(x.getPaymentReference())
          .build();

    }).orElse(null);


  }

  private Product getProduct(String productCode) {
    return this.products.stream().filter(x -> x.getCode().equalsIgnoreCase(productCode)).findFirst().orElse(null);
  }

  @GetMapping(value = "/", params = {"customer"})
  public List<Policy> getAllForCustomer(@RequestParam("customer") String customer) {
    return null;
  }



  @PostMapping({"", "/"})
  public Policy buy(@RequestBody Policy policy) {

    if (isValidProposal(policy)) {
      return issuePolicy(policy);
    }
    String message = String.format("Failed to validate policy issuance. TxN Ref: %s", UUID.randomUUID());
    log.warn("User Message: {}, Policy: {}", message, policy);
    throw invalidRequest(message);
  }
  private boolean isValidProposal(Policy policy) {

    boolean valid = true;
    valid = valid && isValidProduct(policy.getProductCode());
    valid = valid && hasValidPayment(policy);
    return valid;
  }

  private boolean hasValidPayment(Policy policy) {
    return true;
  }

  private boolean isValidProduct(String productCode) {
    return products.stream().map( Product::getCode ).anyMatch(productCode::equalsIgnoreCase);
  }


  private Policy issuePolicy(Policy policy) {

    PolicyContract contract = PolicyContract.builder()
        .customer(findOrSaveCustomer(policy))
        .productCode(policy.getProductCode())
        .coverage(policy.getCoverage())
        .coverEnd(policy.getCoverageEnd())
        .coverStart(policy.getCoverageStart())
        .premium(policy.getPremium())
        .premiumFrequency(policy.getPremiumFrequency())
        .paymentReference(policy.getTransactionReference())
        .status(policy.getStatus())
        .build();
    contract.setDetails(fromMap(contract, policy.getOptions()));
    contracts.save(contract);
    contract.setStatus(APPROVED);
    contracts.save(contract);

    policy.setId(contract.getId());
    policy.setStatus(APPROVED);
    return policy;
  }



  private Customer findOrSaveCustomer(Policy policy) {

    Optional<Customer> customer = customers.findCustomerByEmail(policy.getCustomerEmail());
    if (customer.isPresent()) {
      return customer.get();
    }
    customer = customers.findCustomerByPhoneNumber(policy.getCustomerPhoneNumber());
    if (customer.isPresent()) {
      return customer.get();
    }

    Customer newCustomer = Customer.builder()
        .email(policy.getCustomerEmail())
        .phoneNumber(policy.getCustomerPhoneNumber())
        .active(true)
        .name(policy.getCustomerName())
        .build();
    newCustomer = customers.save(newCustomer);
    return newCustomer;
  }

}

