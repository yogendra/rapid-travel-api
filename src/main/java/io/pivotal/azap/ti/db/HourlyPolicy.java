package io.pivotal.azap.ti.db;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HourlyPolicy {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name="hourly_policy_id", sequenceName = "hourly_policy_id_seq", allocationSize = 1)
  Long id;
  LocalDateTime coverStart;
  LocalDateTime coverEnd;
  String accountNumber;

  @ManyToOne
  Customer customer;

}
