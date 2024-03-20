package com.Integrador.ambientese.login.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@GetMapping("/")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	@GetMapping("/recuperarSenha/email")
	public ModelAndView recuperarSenhaEmail() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("recuperarSenha-email");
		return modelAndView;
	}
	
	@GetMapping("/recuperarSenha/email/codigo")
	public ModelAndView recuperarSenhaCodigo() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("recuperarSenha-codigo");
		return modelAndView;
	}
	
	@GetMapping("/recuperarSenha/email/novo")
	public ModelAndView recuperarSenhaNovo() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("recuperarSenha-novo");
		return modelAndView;
	}
}
