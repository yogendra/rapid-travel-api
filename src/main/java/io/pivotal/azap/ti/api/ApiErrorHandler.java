package io.pivotal.azap.ti.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ApiErrorHandler  {

  @ExceptionHandler(ApiException.class)
  @ResponseBody
  public ResponseEntity<Error> handleError(ApiException ex) {
    return new ResponseEntity<>(ex.getError(), HttpStatus.EXPECTATION_FAILED);
  }
}
