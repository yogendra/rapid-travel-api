package io.pivotal.azap.ti.api;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
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
  private String description;
  private Amount premium;
  private PolicyStatus status;
  private PremiumFrequency premiumFrequency;

  private LocalDateTime coverageStart;
  private LocalDateTime coverageEnd;
  private Amount coverage;
  private String comments;


}


