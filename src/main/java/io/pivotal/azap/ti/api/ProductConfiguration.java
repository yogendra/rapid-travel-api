package io.pivotal.azap.ti.api;

import static io.pivotal.azap.ti.Amount.USD;
import static io.pivotal.azap.ti.PremiumFrequency.ONE_TIME;
import static io.pivotal.azap.ti.api.Product.ProductType.SPORT_SKI;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfiguration {


  @Bean
  public Product weeklySkiInsurance() {
    return Product.builder()
        .code("WSKI001")
        .name("Weekly SKI Insurance by RapidInsure")
        .description(
            "Weekly insurance for skiing anywhere in the world. Offered by RapidInsure, worldwide!")
        .type(SPORT_SKI)
        .premiumType(ONE_TIME)
        .premium(USD(250.00))
        .coverage(USD(10000.00))
        .build();
  }


}
