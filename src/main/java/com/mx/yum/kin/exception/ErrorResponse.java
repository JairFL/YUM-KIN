package com.mx.yum.kin.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
@JsonInclude(JsonInclude.Include.NON_EMPTY) // Ignorar campos nulos
public class ErrorResponse extends RuntimeException{

    private final String message;
	private final List<String> details ;
    private final Integer code;


    public ErrorResponse(String message, String details, List<String> details1, Integer code) {
        this.details = details1;
        this.code = code;
        this.message = message;
        this.details.add(details);
    }
    public ErrorResponse(String message, List<String> details, Integer code) {
        this.message = message;
        this.details = details;
        this.code = code;
    }





    @Override
  public String getMessage() {
    return message;
  }


  public List<String> getDetails() {
    return details;
  }



  public Integer getCode() {
    return code;
  }


    @Override
    public synchronized Throwable fillInStackTrace() {
        return null; // No generar el stack trace
    }

    // Evitar la serialización de los campos de stack trace
    @JsonIgnore
    @Override
    public synchronized Throwable getCause() {
        return null;  // No incluir cause en la serialización
    }


    @JsonIgnore
    @Override
    public String getLocalizedMessage() {
        return super.getLocalizedMessage();  // O puedes retornar un valor vacío si no quieres que se incluya
    }

}



