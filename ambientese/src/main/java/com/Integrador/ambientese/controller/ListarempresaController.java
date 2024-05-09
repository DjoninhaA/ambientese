package com.Integrador.ambientese.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListarempresaController {

    @GetMapping("/empresa")
    public String home() {
        return "listarEmpresa"; // Retorna o nome do arquivo HTML sem a extensão
    }
}


