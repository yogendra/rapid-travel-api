package io.pivotal.azap.ti.api;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.pivotal.azap.ti.db.CustomerRepository;
import java.util.Optional;
import ma.glasnost.orika.MapperFacade;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class CustomerApiTest {

  @Mock
  CustomerRepository repository;
  @Mock
  MapperFacade mapper;

  CustomerApi api;

  @Before
  public void setUp() {
    repository = mock(CustomerRepository.class);
    mapper = mock(MapperFacade.class);

    api = new CustomerApi(repository, mapper);
  }

  @Test
  public void get() {
    Optional<io.pivotal.azap.ti.db.Customer> dbCutomer =
        Optional.of(Mockito.mock(io.pivotal.azap.ti.db.Customer.class));

    Customer apiCustomer = mock(Customer.class);
    when(mapper.map(dbCutomer, Customer.class)).thenReturn(apiCustomer);
    when(repository.findById(1L)).thenReturn(dbCutomer);

    Customer received = api.get(1L);

    assertTrue(received == apiCustomer);
  }

  @Test
  public void getAll() {

  }
}