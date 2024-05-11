package com.Integrador.ambientese.controller;


import com.Integrador.ambientese.interfac.EmpresaRepository;
import com.Integrador.ambientese.model.Empresa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BuscarempresaController {

    private final EmpresaRepository empresaRepository;

    @Autowired
    public BuscarempresaController(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @GetMapping("/empresas")
    public Page<Empresa> getEmpresas(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return empresaRepository.findAll(pageable);
    }

    @DeleteMapping("/empresas/{id}")
    public ResponseEntity<?> deleteEmpresa(@PathVariable Long id) {
        try {
            empresaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar-empresa")
    public String home() {
        return "buscarEmpresa";
    }
}


