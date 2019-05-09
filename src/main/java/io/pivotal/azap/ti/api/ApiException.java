package io.pivotal.azap.ti.api;


import static io.pivotal.azap.ti.api.FieldError.root;

public class ApiException extends RuntimeException {

  private final transient Error error;


  public ApiException(Error error) {
    super();
    this.error = error;
  }

  public static ApiException invalidRequest(String message) {
    return new ApiException(Error.validationError(root(message)));
  }

  @Override
  public String getMessage() {
    return error.getMessage();
  }

  public Error getError() {
    return error;
  }
}
