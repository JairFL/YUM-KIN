package com.mx.yum.kin.services.implement;

import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class OrdenarService {

  public List<String> ordenaNombres(List<String> nombres) {
    Collections.sort(nombres);
    return nombres;
  }


}
