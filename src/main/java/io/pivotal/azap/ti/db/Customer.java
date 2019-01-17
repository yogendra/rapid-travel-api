package io.pivotal.azap.ti.db;

import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @SequenceGenerator(name="customer_id",sequenceName="customer_seq", allocationSize=1)
  private Long id;

  @Column(nullable = false, length = 100)
  private String name;

  private String email;
  private String phoneNumber;
  private Boolean active = Boolean.TRUE;

  @OneToMany
  private List<HourlyPolicy> policies;



}
