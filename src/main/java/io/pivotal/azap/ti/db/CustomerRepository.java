package io.pivotal.azap.ti.db;

import java.util.Optional;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

  Optional<Customer> findCustomerByEmail(String email);

  Optional<Customer> findCustomerByPhoneNumber(String phoneNumber);
}
