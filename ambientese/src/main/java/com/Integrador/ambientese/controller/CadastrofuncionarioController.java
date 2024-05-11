package com.Integrador.ambientese.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CadastrofuncionarioController {
    @GetMapping("/cadastro/funcionario")
    public ModelAndView cadastroFuncionario() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cadastroFuncionario");
        return modelAndView;
    } // Retorna o nome do arquivo HTML sem a extensão

}


