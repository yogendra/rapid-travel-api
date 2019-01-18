package io.pivotal.azap.ti.api;

import io.pivotal.azap.ti.Amount;
import io.pivotal.azap.ti.PolicyStatus;
import io.pivotal.azap.ti.PremiumFrequency;
import java.time.LocalDateTime;
import java.util.Map;
import javax.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Policy {

  private Long id;
  private String name;
  private String customerName;
  private String customerEmail;
  private String customerPhoneNumber;
  private String productCode;
  private Amount premium;

  private PolicyStatus status;
  private PremiumFrequency premiumFrequency;


  private LocalDateTime coverageStart;
  private LocalDateTime coverageEnd;
  private Amount coverage;
  private String comments;
  private String transactionReference;

  private Map<String, String> options;

}


