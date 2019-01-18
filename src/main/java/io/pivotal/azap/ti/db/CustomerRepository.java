package io.pivotal.azap.ti.db;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

  public Optional<Customer> findCustomerByEmail(String email);
  public Optional<Customer> findCustomerByPhoneNumber(String phoneNumber);
}
