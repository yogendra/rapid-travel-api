package io.pivotal.azap.ti;

import java.util.Currency;
import javax.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Embeddable
public class Amount {

  private Currency currency;
  private double number;

  public static Amount USD(double amount) {
    return amount("USD", amount);
  }

  public static Amount amount(String currency, double amount) {
    return new Amount(Currency.getInstance(currency), amount);
  }

}
