package com.Integrador.ambientese.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListarfuncionarioController {

    @GetMapping("/listarfuncionario")
    public String home() {
        return "listarFuncionario"; // Retorna o nome do arquivo HTML sem a extensão
    }
}


