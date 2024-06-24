package com.Integrador.ambientese.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Integrador.ambientese.interfac.EmpresaRepository;
import com.Integrador.ambientese.model.Empresa;

@Controller
@RestController
public class RankingController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping("/ranking")
    public ModelAndView ranking() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("html/ranking");
        return modelAndView;
    }

     @GetMapping("/teste/{idEmpresa}")
    public ResponseEntity<Empresa> GetById(@PathVariable Long idEmpresa){
        Empresa empresa = empresaRepository.findByidEmpresa(idEmpresa);
        return ResponseEntity.ok(empresa);
    }

}
