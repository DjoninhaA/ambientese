package com.Integrador.ambientese.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CadastroempresaController {
    @GetMapping("/cadastro")
    public String home() {
        return "cadastroEmpresa"; // Retorna o nome do arquivo HTML sem a extensão
    }
}
