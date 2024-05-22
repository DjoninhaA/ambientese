package com.Integrador.ambientese.controller;


import com.Integrador.ambientese.model.Empresa;
import com.Integrador.ambientese.model.Endereco;
import com.Integrador.ambientese.model.Funcionarios;
import com.Integrador.ambientese.model.Usuario;
import com.Integrador.ambientese.model.enums.Cargo;
import com.Integrador.ambientese.model.enums.Genero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @GetMapping("/edit/{idFuncionarios}")
    public ModelAndView editarFuncionario() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("html/cadastroFuncionario");
        return modelAndView;
    }

    // @GetMapping("/buscar/funcionario")
    // public ModelAndView listarFuncionarios() {
    //     ModelAndView modelAndView = new ModelAndView();
    //     modelAndView.setViewName("html/listarFuncionario");
    //     return modelAndView;
    // } // Retorna o nome do arquivo HTML sem a extensão

    @GetMapping("/listarFuncionario")
    public ModelAndView cadastroEmperesa() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("html/listarFuncionario");
        return modelAndView;
     }


    @GetMapping("/buscarfuncionario/{idFuncionario}")
    public ResponseEntity<Funcionarios> GetById(@PathVariable long idFuncionario){
        Funcionarios funcionarios = funcionariosRepository.findById(idFuncionario);
        return ResponseEntity.ok(funcionarios);
    }

    @PostMapping("/cadastro/funcionario")
    public ResponseEntity<String> saveFuncionario(
            @RequestParam("nome") String name,
            @RequestParam("cpf") String cpf,
            @RequestParam("data_nascimento") Date dataNascimento,
            @RequestParam("email") String email,
            @RequestParam("cargo") Cargo cargo,
            @RequestParam("genero") Genero genero,
            @RequestParam("login") String login,
            @RequestParam("senha") String senha){
    
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
        
        usuario.setFuncionario(funcionario);
    
        // Salvar a empresa no repositório
        funcionariosRepository.save(funcionario);
        usuarioRepository.save(usuario);
    
        return ResponseEntity.ok("Dados salvos com sucesso!");
    }

    @GetMapping("/funcionarios")
    public Page<Funcionarios> getFuncionarios(@RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size,
                                     @RequestParam(required = false) String sortBy,
                                     @RequestParam(defaultValue = "asc") String sortOrder) {
        Pageable pageable;

        if (sortBy != null && !sortBy.isEmpty()) {
            Sort sort = sortOrder.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
            pageable = PageRequest.of(page, size, sort);
        } else {
            pageable = PageRequest.of(page, size);
        }

        return funcionariosRepository.findAll(pageable);
    }

    @PutMapping("/edit/{idFuncionario}")
    public ResponseEntity<String> atualizarFuncionario(
            @PathVariable long idFuncionario,
            @RequestParam("nome") String name,
            @RequestParam("cpf") String cpf,
            @RequestParam("email") String email,
            @RequestParam("telefone") String telefone,
            @RequestParam("data_nascimento") Date dataNascimento,
            @RequestParam("cargo") Cargo cargo,
            @RequestParam("genero") Genero genero) {

        return funcionariosRepository.findById(idFuncionario)
                .map(funcionarios -> {
                    funcionarios.setName(name);
                    funcionarios.setCpf(cpf);
                    funcionarios.setEmail(email);
                    funcionarios.setTelefone(telefone);
                    funcionarios.setDataNascimento(dataNascimento);
                    funcionarios.setCargo(cargo);
                    funcionarios.setGenero(genero);


                    funcionariosRepository.save(funcionarios);
                    return ResponseEntity.ok("Funcionario atualizada com sucesso!");
                })
                .orElse(ResponseEntity.notFound().build());

    }


    @DeleteMapping("/funcionario/delete/{idFuncionario}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable Long idFuncionario){
        funcionariosRepository.deleteById(idFuncionario);
        return ResponseEntity.noContent().build();
    }



}


