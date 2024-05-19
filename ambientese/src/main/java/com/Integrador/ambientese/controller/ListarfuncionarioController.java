package com.Integrador.ambientese.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListarfuncionarioController {

    @GetMapping("/funcionario")
    public ModelAndView mostrarFormulario() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("html/listarFuncionario");
        return modelAndView;
    }
}


