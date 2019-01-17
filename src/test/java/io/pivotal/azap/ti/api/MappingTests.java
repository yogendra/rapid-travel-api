package io.pivotal.azap.ti.api;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import io.pivotal.azap.ti.db.Customer;
import io.pivotal.azap.ti.db.DailyPolicy;
import lombok.Setter;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MappingTests {


  @Autowired
  private MapperFacade mapperFacade;


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

  @Test
  public void mapPolicyFromDbToApi() {

    Long id = Long.MAX_VALUE;
    String email = "a@b.com";
    String phoneNumber = "phone-number-here";
    String name = "name here";

    DailyPolicy dailyPolicy = DailyPolicy.builder()
        .id(id)
        .name(name)
        .build();


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
