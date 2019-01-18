package io.pivotal.azap.ti.api;


import static io.pivotal.azap.ti.api.FieldError.root;

public class ApiException extends RuntimeException{

  private Error error;

  public ApiException() {
    super();
    this.error = Error.builder().code(Error.CODE_UNKNOWN).message("Unknown Error").build();
  }

  public ApiException(Error error){
    super();
    this.error = error;
  }

  @Override
  public String getMessage() {
    return error.getMessage();
  }

  public Error getError() {
    return error;
  }

  public static ApiException invalidRequest(String message){
    return new ApiException(Error.validationError( root(message)));
  }
}
