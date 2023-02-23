package com.example.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Objects;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(MethodArgumentTypeMismatchException.class)
  public ResponseEntity<ErrorResponse> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
    log.info("HandleTypeMismatch called with {}",ex.getMessage());
    String name = ex.getName();
    String type = Objects.requireNonNull(ex.getRequiredType()).getSimpleName();
    Object value = ex.getValue();
    String message = String.format("'%s' should be a valid '%s' and '%s' isn't",
            name, type, value);

    return buildErrorResponse(ex, message, HttpStatus.UNPROCESSABLE_ENTITY);
  }

  @ExceptionHandler(RuntimeException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<ErrorResponse> handleAllUncaughtException(
          RuntimeException exception,
          WebRequest request
  ) {
    log.error("UncaughtException occurred with {}",request);
    return buildErrorResponse(exception, exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
  }

  private ResponseEntity<ErrorResponse> buildErrorResponse(
          Exception ex,
          String message,
          HttpStatus httpStatus
  ) {
    log.error("Build error response with ex: {}, HttpStatus: {}",ex.getMessage(), httpStatus);
    ErrorResponse errorResponse = new ErrorResponse(
            httpStatus.value(),
            message
    );

    return new ResponseEntity<>(errorResponse, httpStatus);
  }
}