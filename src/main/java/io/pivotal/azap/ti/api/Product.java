package io.pivotal.azap.ti.api;

import static io.pivotal.azap.ti.api.Product.ParameterType.DATE;
import static io.pivotal.azap.ti.api.Product.ParameterType.DATETIME;
import static io.pivotal.azap.ti.api.Product.ParameterType.NUMBER;
import static io.pivotal.azap.ti.api.Product.ParameterType.TEXT;
import static io.pivotal.azap.ti.api.Product.ParameterType.TIME;
import static io.pivotal.azap.ti.api.Product.ProductType.GENERAL;

import io.pivotal.azap.ti.Amount;
import io.pivotal.azap.ti.PremiumFrequency;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Builder.Default;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Singular;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Product {
  @NonNull
  private String code;

  @NonNull
  @Default
  private ProductType type = GENERAL;

  @NonNull
  private String name;
  @NonNull
  private String description;
  @NonNull
  private PremiumFrequency premiumType;
  @NonNull
  private Amount premiumAmount;

  @NonNull
  private Amount coverage;

  @Default
  private String smallBanner = "banner-small.jpg";
  @Default
  private String mediumBanner =  "banner-medium.jpg";
  @Default
  private String largeBanner = "banner-large.jpg";

  @NonNull
  @Singular
  private List<PolicyParameter> parameters;


  enum ParameterType {
    TEXT, DATE, TIME, DATETIME, NUMBER
  }


  @Data
  @NoArgsConstructor
  @AllArgsConstructor
  @RequiredArgsConstructor
  @Builder
  public static class PolicyParameter {

    @NonNull
    private String name;
    @Default
    private String description = "";
    @Default
    private boolean required = true;
    @NonNull
    private ParameterType type;

    public static PolicyParameter requiredDate(String name, String description) {
      return option(DATE, true, name, description);
    }

    public static PolicyParameter requiredDateTime(String name, String description) {
      return option(DATETIME, true, name, description);
    }

    public static PolicyParameter requiredTime(String name, String description) {
      return option(TIME, true, name, description);
    }

    public static PolicyParameter requiredNumber(String name, String description) {
      return option(NUMBER, true, name, description);
    }

    public static PolicyParameter requiredText(String name, String description) {
      return option(TEXT, true, name, description);
    }

    public static PolicyParameter optionalDate(String name, String description) {
      return option(DATE, false, name, description);
    }

    public static PolicyParameter optionalDateTime(String name, String description) {
      return option(DATETIME, false, name, description);
    }


    public static PolicyParameter optionalTime(String name, String description) {
      return option(TIME, false, name, description);
    }

    public static PolicyParameter optionalNumber(String name, String description) {
      return option(NUMBER, false, name, description);
    }

    public static PolicyParameter optionalText(String name, String description) {
      return option(TEXT, false, name, description);
    }


    private static PolicyParameter option(ParameterType type, boolean required, String name,
        String description) {
      return PolicyParameter.builder()
          .name(name)
          .description(description)
          .required(required)
          .type(type)
          .build();
    }
  }

  enum ProductType {
    GENERAL, LIFE, TRAVEL, SPORT_SKI
  }

}
