package com.Integrador.ambientese.controller;


import com.Integrador.ambientese.model.Empresa;
import com.Integrador.ambientese.model.Endereco;
import com.Integrador.ambientese.model.Funcionarios;
import com.Integrador.ambientese.model.Usuario;
import com.Integrador.ambientese.model.enums.Cargo;
import com.Integrador.ambientese.model.enums.Genero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import com.Integrador.ambientese.interfac.FuncionariosRepository;
import com.Integrador.ambientese.interfac.UsuarioRepository;

import java.sql.Date;
import java.util.List;

@RestController
public class CadastrofuncionarioController {

    @Autowired
    private FuncionariosRepository funcionariosRepository;
    @Autowired
    private UsuarioRepository usuarioRepository; 

    @GetMapping("/cadastro/funcionario")
    public ModelAndView cadastroFuncionario() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("html/cadastroFuncionario");
        return modelAndView;
    } // Retorna o nome do arquivo HTML sem a extensão

    @GetMapping("/buscar/funcionario")
    public ResponseEntity<List<Funcionarios>> GetAll(){
        List<Funcionarios>allFuncionarios = funcionariosRepository.findAll();
        return ResponseEntity.ok(allFuncionarios);
    }

    @GetMapping("/buscarfuncionario/{idFuncionario}")
    public ResponseEntity<Funcionarios> GetById(@PathVariable long idFuncionario){
        Funcionarios funcionarios = funcionariosRepository.findById(idFuncionario);
        return ResponseEntity.ok(funcionarios);
    }

    @PostMapping("/cadastro/funcionario")
    public ResponseEntity<String> saveFuncionario(
            @RequestParam("nome") String name,
            @RequestParam("CPF") String cpf,
            @RequestParam("data_nascimento") Date dataNascimento,
            @RequestParam("email") String email,
            @RequestParam("cargo") Cargo cargo,
            @RequestParam("genero") Genero genero,
            @RequestParam("login") String login,
            @RequestParam("senha") String senha,
            @RequestParam("isAdmin") int isAdmin){
    
        Funcionarios funcionario = new Funcionarios();
        funcionario.setName(name);
        funcionario.setCpf(cpf);
        funcionario.setDataNascimento(dataNascimento);
        funcionario.setEmail(email);
        funcionario.setCargo(cargo);
        funcionario.setGenero(genero);
    
        // Criar o objeto Endereco e configurar os dados
        Usuario usuario = new Usuario();
        usuario.setLogin(login);
        usuario.setSenha(senha);
        usuario.setIsAdmin(isAdmin);
    
        // Salvar a empresa no repositório
        funcionariosRepository.save(funcionario);
        usuarioRepository.save(usuario);
    
        return ResponseEntity.ok("Dados salvos com sucesso!");
    }



    @PutMapping("/edit/{idFuncionario}")
    public Funcionarios atualizarFuncionarios(@RequestBody Funcionarios funcionariosAtualizados, @PathVariable long idFuncionario){
       try {
           Funcionarios funcionarioAtual = funcionariosRepository.findById(idFuncionario);
           funcionarioAtual.setCargo(funcionariosAtualizados.getCargo());
           funcionarioAtual.setName(funcionariosAtualizados.getName());
           funcionarioAtual.setCpf(funcionariosAtualizados.getCpf());
           funcionarioAtual.setEmail(funcionariosAtualizados.getEmail());
           funcionarioAtual.setDataNascimento(funcionariosAtualizados.getDataNascimento());
           funcionarioAtual.setCargo(funcionariosAtualizados.getCargo());
           funcionarioAtual.setGenero(funcionariosAtualizados.getGenero());

           funcionariosRepository.save(funcionarioAtual);

           return funcionarioAtual;
       } catch (Exception e){
           throw new RuntimeException("Funcionario não encontrado com o ID: " + idFuncionario);
       }
    }

    @DeleteMapping("/delete/{idFuncionario}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable Long idFuncionario){
        funcionariosRepository.deleteById(idFuncionario);
        return ResponseEntity.noContent().build();
    }



}


