package io.pivotal.azap.ti.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Customer {

  private Long id;
  private String name;
  private String phoneNumber;
  private String email;

}
