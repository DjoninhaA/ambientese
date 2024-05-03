package com.Integrador.ambientese.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Integrador.ambientese.interfac.EmpresaRepository;
import com.Integrador.ambientese.model.Empresa;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping("/cadastro")
    public String home() {
        return "cadastroEmpresa"; // Retorna o nome do arquivo HTML sem a extensão
    }



    // @GetMapping("/buscaEmpresa")
    // public ResponseEntity<List<Empresa>>GetAll(){
    //     List<Empresa>allEmpresas = empresaRepository.findAll();
    //     return ResponseEntity.ok(allEmpresas);
    // }

    @GetMapping("/buscaEmpresa")
    public ResponseEntity<Empresa> GetByName(@PathVariable String nome_fantasia){
        Empresa empresa = empresaRepository.findByNomeFantasia(nome_fantasia);
        return ResponseEntity.ok(empresa);
    }

    @PostMapping("/")
    public ResponseEntity<Empresa> PostEmpresa(@RequestBody Empresa empresa){
        empresaRepository.save(empresa);
        return ResponseEntity.ok(empresa);
    }


}

