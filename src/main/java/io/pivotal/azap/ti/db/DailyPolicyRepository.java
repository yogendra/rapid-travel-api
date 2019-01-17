package io.pivotal.azap.ti.db;


import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface DailyPolicyRepository extends PagingAndSortingRepository<DailyPolicy, Long> {

}
