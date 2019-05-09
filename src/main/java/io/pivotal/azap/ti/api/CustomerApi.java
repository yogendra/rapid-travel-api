package io.pivotal.azap.ti.api;

import io.pivotal.azap.ti.db.CustomerRepository;
import java.util.List;
import java.util.Optional;
import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerApi {

  private CustomerRepository customers;
  private MapperFacade mapperFacade;

  @Autowired
  public CustomerApi(CustomerRepository customers, MapperFacade mapperFacade) {
    this.customers = customers;
    this.mapperFacade = mapperFacade;
  }

  @GetMapping("/{id}")
  public Customer get(@PathVariable Long id) {
    Optional<io.pivotal.azap.ti.db.Customer> dbCustomer = customers.findById(id);
    if (dbCustomer.isPresent()) {
      return mapperFacade.map(dbCustomer, Customer.class);
    }
    return null;
  }

  @GetMapping({"", "/"})
  public List<Customer> getAll() {
    return mapperFacade.mapAsList(customers.findAll(), Customer.class);
  }
}
