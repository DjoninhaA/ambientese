package com.Integrador.ambientese.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BuscarempresaController {

    @GetMapping("/buscar-empresa")
    public String home() {
        return "buscarEmpresa"; // Retorna o nome do arquivo HTML sem a extensão
    }
}


