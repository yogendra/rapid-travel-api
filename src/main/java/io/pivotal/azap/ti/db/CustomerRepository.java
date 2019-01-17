package io.pivotal.azap.ti.db;

import java.util.UUID;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {

}
