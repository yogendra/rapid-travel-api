package io.pivotal.azap.ti.db;

import static java.util.stream.Collectors.toList;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class PolicyContractDetail {

  @Id
  private Long id;

  @OneToOne
  @JsonBackReference
  private PolicyContract contract;

  @NonNull
  private String name;
  private String value;

  public static List<PolicyContractDetail> fromMap(PolicyContract contract,
      Map<String, String> map) {
    if (map != null) {
      return map.entrySet()
          .stream()
          .map(s -> new PolicyContractDetail(null, contract, s.getKey(), s.getValue()))
          .collect(toList());
    } else {
      return Collections.emptyList();
    }

  }

}
