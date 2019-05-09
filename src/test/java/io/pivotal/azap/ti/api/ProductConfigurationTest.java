package io.pivotal.azap.ti.api;

import static org.hamcrest.Matchers.arrayContaining;
import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductConfigurationTest {

  @Autowired
  private List<Product> products;

  @Test
  public void checkProducts() {

    String[] expectedProductCodes = {"WSKI001"};

    String[] actual = products.stream()
        .map(Product::getCode)
        .toArray(String[]::new);

    assertThat(actual, arrayContaining(expectedProductCodes));
  }
}
