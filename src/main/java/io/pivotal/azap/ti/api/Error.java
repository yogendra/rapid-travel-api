package io.pivotal.azap.ti.api;

import java.util.Arrays;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Error {
  public static final String CODE_UNKNOWN = "UNKNONW";
  public static final String CODE_ACCESS = "ACCESS";
  public static final String CODE_VALIDATION = "VALIDATION";
  public static final String CODE_DUPLICATE = "DUPLICATE";



  private String message;
  private String code;
  private List<FieldError> fieldErrors;

  public static final Error validationError(FieldError... errors){
    return Error.builder()
        .code(CODE_VALIDATION)
        .message("Validation Error")
        .fieldErrors(Arrays.asList(errors))
        .build();
  }

  public static final Error duplicateRecord(){
    return Error.builder()
        .code(CODE_DUPLICATE)
        .message("Duplicate Record")
        .build();
  }

  public static final Error accessDenied(){
    return Error.builder()
        .code(CODE_ACCESS)
        .message("Duplicate Record")
        .build();
  }


}
