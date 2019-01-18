package io.pivotal.azap.ti.db;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.pivotal.azap.ti.Amount;
import io.pivotal.azap.ti.PolicyStatus;
import io.pivotal.azap.ti.PremiumFrequency;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PolicyContract {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name="hourly_policy_id", sequenceName = "hourly_policy_id_seq", allocationSize = 1)
  private Long id;
  @ManyToOne
  Customer customer;

  private LocalDateTime coverStart;
  private LocalDateTime coverEnd;
  private String accountNumber;
  private String productCode;
  @Embedded
  @AttributeOverrides(
      {
          @AttributeOverride(name="amount", column = @Column(name="coverage_amount")),
          @AttributeOverride(name="currency", column = @Column(name="coverage_currency"))
      }

  )
  private Amount coverage;

  @Embedded
  @AttributeOverrides(
      {
          @AttributeOverride(name="amount", column = @Column(name="premium_amount")),
          @AttributeOverride(name="currency", column = @Column(name="premium_currency"))
      }

  )
  private Amount premium;
  private PremiumFrequency premiumFrequency;
  private String paymentReference;
  private PolicyStatus status;





  @OneToMany
  @Singular
  @JsonManagedReference
  List<PolicyContractDetail> details;


}
