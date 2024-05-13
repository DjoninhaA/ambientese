package com.Integrador.ambientese.controller;


import com.Integrador.ambientese.interfac.LoginRepository;
import com.Integrador.ambientese.model.Empresa;
import com.Integrador.ambientese.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RestController
public class LoginController {

	@Autowired
	private LoginRepository loginRepository;

	@GetMapping("/auth")
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("html/login");
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
	@GetMapping("/buscarNome")
	public ResponseEntity<List<Usuario>> GetAll(){
		List<Usuario>allUsuario = loginRepository.findAll();
		return ResponseEntity.ok(allUsuario);
	}
	@PostMapping("/login")
	public RedirectView login(@RequestParam("login") String login, @RequestParam("senha") String senha, RedirectAttributes attributes) {
		List<Usuario> allUsuarios = loginRepository.findAll();
		Usuario usuario = allUsuarios.stream()
				.filter(u -> u.getLogin().equals(login) && u.getSenha().equals(senha))
				.findFirst()
				.orElse(null);

		if (usuario != null) {
			attributes.addFlashAttribute("successMessage", "Login bem-sucedido!");
			return new RedirectView("/home");
		} else {
			attributes.addFlashAttribute("errorMessage", "Falha no login! Usuário ou senha incorretos.");
			return new RedirectView("/Erro");
		}
	}


	@GetMapping("/Erro")
	public String erro() {
		return "Erro";
	}



}
