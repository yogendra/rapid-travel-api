package io.pivotal.azap.ti.api;

import static io.pivotal.azap.ti.Amount.USD;
import static io.pivotal.azap.ti.PremiumFrequency.ONE_TIME;
import static io.pivotal.azap.ti.api.Product.ProductType.SPORT_SKI;
import static io.pivotal.azap.ti.api.Product.ProductType.TRAVEL;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProductConfiguration {


  @Bean
  public Product travelInsurance() {
    return Product.builder()
        .code("TRVL001")
        .name("Travel Insurance Worldwide")
        .description("Worldwide Travel Insurance provides you with protection anywhere, anytime.")
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
        .name("Weekly SKI Insurance")
        .description("Weekly insurance for skiing anywhere in the world")
        .type(SPORT_SKI)
        .premiumType(ONE_TIME)
        .premium(USD(50.00))
        .coverage(USD(20000.00))
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
        .premium(USD(100.00))
        .coverage(USD(5000.00))
        .build();
  }


}
