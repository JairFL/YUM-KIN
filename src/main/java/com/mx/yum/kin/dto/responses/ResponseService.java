package com.mx.yum.kin.dto.responses;

import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseService<T> {
  private boolean success;

  private T response;


  private String message;

  public ResponseService() {

  }

  public ResponseService(String message) {
    super();
    this.message = message;
  }

  public ResponseEntity<ResponseService<T>> obtenerRespuestaError(String message) {
    this.success = false;
    this.message = message;
    return new ResponseEntity<>(this, HttpStatus.EXPECTATION_FAILED);
  }

  public ResponseEntity<ResponseService<T>> obtenerRespuestaError(@NotNull T response, String message) {
    this.response = response;
    this.success = false;
    this.message = message;
    return new ResponseEntity<>(this, HttpStatus.EXPECTATION_FAILED);
  }

  public ResponseEntity<ResponseService<T>> obtenerRespuesta( T response, String message) {
    this.success = true;
    this.response = response;
    this.message = message;
    return new ResponseEntity<>(this, HttpStatus.OK);
  }


  public boolean isSuccess() {
    return success;
  }


  public T getResponse() {
    return response;
  }


  public String getMessage() {
    return message;
  }


  public void setSuccess(boolean success) {
    this.success = success;
  }

  public void setResponse(T response) {
    this.response = response;
  }


  public void setMessage(String message) {
    this.message = message;
  }
}
