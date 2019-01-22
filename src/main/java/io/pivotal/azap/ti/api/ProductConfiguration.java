package io.pivotal.azap.ti.api;

import static io.pivotal.azap.ti.Amount.USD;
import static io.pivotal.azap.ti.PremiumFrequency.ONE_TIME;
import static io.pivotal.azap.ti.api.Product.ProductType.SPORT_SKI;
import static io.pivotal.azap.ti.api.Product.ProductType.TRAVEL;

import io.pivotal.azap.ti.api.Product.PolicyParameter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfiguration {


  @Bean
  public Product travelInsurance() {
    return Product.builder()
        .code("TRVL001")
        .name("Travel Insurance Worldwide by RapidInsure")
        .description(
            "Worldwide Travel Insurance provides you with protection anywhere, anytime. Offered by RapidInsure, worldwide!")
        .type(TRAVEL)
        .premiumType(ONE_TIME)
        .premium(USD(20.00))
        .coverage(USD(10000))
        .build();
  }


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

  @Bean
  public Product hourlySkiProduct() {
    return Product.builder()
        .code("HSKI001")
        .name("Hourly Ski Policy ")
        .description("Gives you coverage by hour")
        .type(SPORT_SKI)
        .premiumType(ONE_TIME)
        .premium(USD(10.00))
        .coverage(USD(10000.00))
        .parameter(PolicyParameter.requiredNumber("Hours", "No. of Hours"))
        .build();
  }
}
