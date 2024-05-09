package com.Integrador.ambientese.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RestController
public class RankingController {
    @GetMapping("/ranking")
    public ModelAndView ranking() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("html/ranking");
        return modelAndView;
    }

}
