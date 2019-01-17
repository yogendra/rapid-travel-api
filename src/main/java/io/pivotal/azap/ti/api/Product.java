package io.pivotal.azap.ti.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Product {
  private Long id;
  private String name;
  private String description;
  private PremiumFrequency premiumType;
  private Amount premiumAmount;
  private String smallBanner;
  private String mediumBanner;
  private String largeBanner;

}
