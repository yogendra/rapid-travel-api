package io.pivotal.azap.ti.db;

import io.pivotal.azap.ti.api.Customer;
import java.util.UUID;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {

}
