package com.mx.yum.kin.controllers;


import com.mx.yum.kin.services.implement.OrdenarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/user/v1")
@Validated
public class UsuarioController {

  private final OrdenarService ordenarService;


  @Autowired
  public UsuarioController(OrdenarService ordenarService) {
    this.ordenarService = ordenarService;
  }

  @PostMapping("/sort-names")
  public List<String> ordenaNombre(@RequestBody List<String> nombres) {


    return ordenarService.ordenaNombres(nombres);
  }

}

