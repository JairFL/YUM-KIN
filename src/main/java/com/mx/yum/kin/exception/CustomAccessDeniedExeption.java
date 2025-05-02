package com.mx.yum.kin.exception;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.List;

/*
    Sirve para la excetion de spring security
    que manda cuando un user no tiene
    acceso a una ruta.
 */
@Component
public class CustomAccessDeniedExeption implements AccessDeniedHandler {
  @Override
  public void handle(HttpServletRequest request, HttpServletResponse response,
                     AccessDeniedException accessDeniedException) throws IOException {


    ErrorResponse errorResponse =
            new ErrorResponse(
                    "Acceso denegado",
                    List.of("El usuario no cuenta con permisos suficientes para acceder "),
                    401);


    ObjectMapper objectMapper = new ObjectMapper();
    String jsonResponse = objectMapper.writeValueAsString(errorResponse);

    response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 401
    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    response.getWriter().write(jsonResponse);
    response.getWriter().flush();
  }
}
