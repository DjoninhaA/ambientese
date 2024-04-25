package com.Integrador.ambientese.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.Integrador.ambientese.interfac.EmpresaRepository;
import com.Integrador.ambientese.model.Empresa;

@Controller
public class CadastroempresaController {
    @Autowired
    private EmpresaRepository repositorio;

    @GetMapping("/cadastro")
    public String home() {
        return "cadastroEmpresa"; // Retorna o nome do arquivo HTML sem a extensão
    }


    @GetMapping
    public List<Empresa> ListarEmpresa(){
        return repositorio.findAll();
    }
}
