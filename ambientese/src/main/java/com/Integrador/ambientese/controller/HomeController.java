package com.Integrador.ambientese.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

    @Controller
    public class HomeController {

        @GetMapping("/home")
        public String home() {
            return "home"; // Retorna o nome do arquivo HTML sem a extensão
        }
    }


