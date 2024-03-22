package com.Integrador.ambientese.login.controller;


import com.Integrador.ambientese.interfac.LoginRepository;
import com.Integrador.ambientese.model.Login;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RestController
public class LoginController {

	@Autowired
	private LoginRepository loginRepository;

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

	@PostMapping("/login")
	public RedirectView login(@ModelAttribute Login login, RedirectAttributes attributes) {
		// Esta linha define um método chamado `login` que aceita um objeto `Login` como entrada.
		// A anotação `@RequestBody` indica que o objeto `Login` deve ser vinculado a partir do corpo da solicitação HTTP.
		Login existingLogin = loginRepository.findByUserName(login.getUserName());
		// Aqui, o método `findByUserName` é chamado no `loginRepository` para buscar um registro de login existente no banco de dados
		// com o mesmo nome de usuário que o fornecido no objeto `login`. O resultado é armazenado na variável `existingLogin`.
		if (existingLogin != null && existingLogin.getPassword().equals(login.getPassword())) {
			// Esta linha verifica se o login existente foi encontrado (ou seja, `existingLogin` não é nulo)
			// e se a senha do login existente corresponde à senha fornecida no objeto `login`.
			attributes.addFlashAttribute("successMessage", "Login bem-sucedido!");
			return new RedirectView("/home");
			// Se as condições acima forem verdadeiras, uma resposta HTTP 200 (OK) é retornada com a mensagem "Login bem-sucedido!".
		} else {
			// Se o login existente não foi encontrado ou as senhas não correspondem, o bloco de código dentro do else é executado.
			attributes.addFlashAttribute("errorMessage", "Falha no login!");
			return new RedirectView("/Erro");
			// Uma resposta HTTP 401 (Não Autorizado) é retornada com a mensagem "Falha no login!" no corpo.
		}
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/Erro")
	public String erro() {
		return "Erro";
	}



}
