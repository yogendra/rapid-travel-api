package io.pivotal.azap.ti.api;

import io.pivotal.azap.ti.db.CustomerRepository;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerApi {

  private CustomerRepository customers;

  @Autowired
  public CustomerApi(CustomerRepository customers) {
    this.customers = customers;
  }

  @GetMapping("/{id}")
  public Customer get(@PathVariable Long id){
    return Customer.builder().id(id).build();
  }

  @GetMapping("/")
  public List<Customer> getAll(){
    return StreamSupport.stream(customers.findAll().spliterator(), false)
        .map(c ->{
          return Customer.builder()
              .id(c.getId())
              .email(c.getEmail())
              .name(c.getName())
              .phoneNumber(c.getPhoneNumber())
              .build();
        })
        .collect(Collectors.toList());
  }
}
