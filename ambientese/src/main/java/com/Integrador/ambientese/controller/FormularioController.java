package com.Integrador.ambientese.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FormularioController {

    @GetMapping("/formulario")
    public String formulario() {
        return "html/formularioEmpresa";
    }


}
