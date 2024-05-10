package com.Integrador.ambientese.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
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
import org.springframework.web.servlet.ModelAndView;

@RestController
//@RequestMapping("/empresa")
@Controller
public class CadastroempresaController {
    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping("/cadastro/empresa")
    public ModelAndView cadastroDeEmpresa() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cadastroDeEmpresa");
        return modelAndView;
    } // Retorna o nome do arquivo HTML sem a extensão



    @GetMapping("/buscarTodas")
    public ResponseEntity<List<Empresa>>GetAll(){
        List<Empresa>allEmpresas = empresaRepository.findAll();
        return ResponseEntity.ok(allEmpresas);
    }

    @GetMapping("/buscaEmpresa/{nome_fantasia}")
    public ResponseEntity<Empresa> GetByName(@PathVariable String nome_fantasia){
        Empresa empresa = empresaRepository.findByNomeFantasia(nome_fantasia);
        return ResponseEntity.ok(empresa);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Empresa> PostEmpresa(@RequestBody Empresa empresa){
        empresaRepository.save(empresa);
        System.err.println(empresa);
        return ResponseEntity.ok(empresa);
    }


}

