package com.mx.yum.kin.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class ExceptionGlobal {

	@ExceptionHandler(ErrorResponse.class)
	public ResponseEntity<Object> portalException(ErrorResponse ex, WebRequest request) {
    ErrorResponse respuestaError = new ErrorResponse(ex.getMessage(),
				ex.getDetails(), ex.getCode());
		return new ResponseEntity<>(respuestaError, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Object> handle(MethodArgumentTypeMismatchException ex) {
		ErrorResponse por = new ErrorResponse("Error en los parametros",List.of(ex.getMessage()),400);
		return this.portalException(por, null);
	}

  @ExceptionHandler(MethodArgumentNotValidException.class)
  protected ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
    Map<String, String> errors = new HashMap<>();

    // Itera sobre todos los errores de validación
    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
      errors.put(error.getField(), error.getDefaultMessage());  // Campo y mensaje de error
    }

    return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
  }
  @ExceptionHandler(Exception.class)
  public ResponseEntity<Object>  handleAllExceptions(Exception ex) {
    ErrorResponse respuestaError = new ErrorResponse(ex.getMessage(),new ArrayList<>(),500);
    return new ResponseEntity<>(respuestaError, HttpStatus.BAD_REQUEST);

  }


}
