package io.pivotal.azap.ti.api;


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
}
