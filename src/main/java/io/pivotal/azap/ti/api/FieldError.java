package io.pivotal.azap.ti.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FieldError {

  private String path;
  private String message;
  private String code;

  public static FieldError root(String message) {
    return new FieldError("/", message, "root-object-error");
  }

}
