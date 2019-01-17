package io.pivotal.azap.ti.api;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

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
