package io.pivotal.azap.ti;

import static io.pivotal.azap.ti.Amount.USD;
import static io.pivotal.azap.ti.Amount.amount;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Currency;
import org.junit.Test;

public class AmountTest {

  @Test
  public void supportsUSD() {
    assertThat(USD(10.0).getCurrency(), is(Currency.getInstance("USD")));
  }

  @Test
  public void supportsValidCurrencyAmount() {
    assertThat(amount("INR", 10.0).getCurrency(), is(Currency.getInstance("INR")));
  }

  @Test(expected = Exception.class)
  public void doesNotSupportInvalidCurrency() {
    amount("HYHYHYHY", 10.0);

  }
}