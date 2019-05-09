package io.pivotal.azap.ti.api;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import io.pivotal.azap.ti.db.Customer;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.junit.Before;
import org.junit.Test;


public class MappingTests {

  private MapperFacade mapperFacade;

  @Before
  public void setUp() {
    MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
    this.mapperFacade = mapperFactory.getMapperFacade();
  }

  @Test
  public void mapCustomerFromDbToApi() {

    Long id = Long.MAX_VALUE;
    String email = "a@b.com";
    String phoneNumber = "phone-number-here";
    String name = "name here";

    Customer dbCustomer = Customer.builder()
        .active(true)
        .email(email)
        .id(Long.MAX_VALUE)
        .name(name)
        .phoneNumber(phoneNumber)
        .build();
    io.pivotal.azap.ti.api.Customer apiCustomer = mapperFacade.map(dbCustomer,
        io.pivotal.azap.ti.api.Customer.class);

    assertThat(apiCustomer.getEmail(), is(email));
    assertThat(apiCustomer.getId(), is(id));
    assertThat(apiCustomer.getName(), is(name));
    assertThat(apiCustomer.getPhoneNumber(), is(phoneNumber));

  }


}
