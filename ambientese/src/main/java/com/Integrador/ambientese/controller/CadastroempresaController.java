package com.Integrador.ambientese.controller;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.Integrador.ambientese.interfac.EmpresaRepository;

@Controller
public class CadastroempresaController {
    @GetMapping("/cadastro")
    public String home() {
        return "cadastroEmpresa"; // Retorna o nome do arquivo HTML sem a extensão
    }

    private EmpresaRepository repositorio;

    @GetMapping
    public List<EmpresaRepository> ListarEmpresa(){
        return repositorio.findAll();

    }


}
