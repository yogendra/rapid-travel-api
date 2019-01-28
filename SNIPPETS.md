# Code Snippets

## Add a new policy

```java

@Configuration
class ProductConfiguration{
  /* .... */

  @Bean
  public Product dailySkiInsurance() {
    return Product.builder()
        .code("WSKI002")
        .name("Daily SKI Insurance")
        .description("Daily insurance for skiing anywhere in the world")
        .type(SPORT_SKI)
        .premiumType(ONE_TIME)
        .premium(USD(12.00))
        .coverage(USD(2000.00))
        .build();
  }
  /* .... */
}

```
