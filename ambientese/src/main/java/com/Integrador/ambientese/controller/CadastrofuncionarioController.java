package com.Integrador.ambientese.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CadastrofuncionarioController {

    @GetMapping("/cadastrofuncionario")
    public String home() {
        return "cadastroFuncionario"; // Retorna o nome do arquivo HTML sem a extensão
    }
}


