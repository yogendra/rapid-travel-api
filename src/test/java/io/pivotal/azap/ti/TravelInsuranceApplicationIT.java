package io.pivotal.azap.ti;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import io.pivotal.azap.ti.api.Policy;
import io.pivotal.azap.ti.api.PolicyApi;
import io.pivotal.azap.ti.api.Product;
import io.pivotal.azap.ti.api.ProductApi;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TravelInsuranceApplicationIT {

  @Test
  public void contextLoads() {
    // This will ensure that all the config is working
  }

  @Autowired
  public PolicyApi policyApi;

  @Autowired
  public ProductApi productApi;


  @Test
  public void loadPolifiedOfACustomer() {
    List<Policy> policies = policyApi.getAllForCustomer("Test");
    assertThat(policies.size(), is(0));
  }

  @Test
  public void loadPolicyById() {
    Policy policy = policyApi.get(1L);
    assertThat(policy, nullValue());
  }

  @Test
  public void productByType() {
    List<Product> products = productApi.getAllByType("SPORT_SKI");
    assertFalse(products.isEmpty());
  }

  @Test
  public void allProduct() {
    List<Product> products = productApi.getAll();
    assertFalse(products.isEmpty());
  }

  @Test
  public void productByCode() {
    Optional<Product> product = productApi.get("WSKI001");
    assertTrue(product.isPresent());
    assertThat(product.get()
        .getCode(), is("WSKI001"));

  }

}

