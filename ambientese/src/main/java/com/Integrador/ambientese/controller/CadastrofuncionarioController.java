package com.Integrador.ambientese.controller;


import com.Integrador.ambientese.model.Funcionarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import com.Integrador.ambientese.interfac.FuncionariosRepository;

import java.util.List;

@RestController
public class CadastrofuncionarioController {

    @Autowired
    private FuncionariosRepository funcionariosRepository;

    @GetMapping("/cadastro/funcionario")
    public ModelAndView cadastroFuncionario() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cadastroFuncionario");
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

    @PostMapping("/cadastrar/funcionario")
    public ResponseEntity<Funcionarios> postFuncionarios(@RequestBody Funcionarios funcionarios){
        Funcionarios savedFuncionario = funcionariosRepository.save(funcionarios);
        return ResponseEntity.ok(savedFuncionario);
    }



    @PutMapping("/edit/{idFuncionario}")
    public Funcionarios atualizarFuncionarios(@RequestBody Funcionarios funcionariosAtualizados, @PathVariable long idFuncionario){
       try {
           Funcionarios funcionarioAtual = funcionariosRepository.findById(idFuncionario);
           funcionarioAtual.setCargo(funcionarioAtual.getCargo());
           funcionarioAtual.setName(funcionariosAtualizados.getName());
           funcionarioAtual.setCpf(funcionariosAtualizados.getCpf());
           funcionarioAtual.setEmail(funcionariosAtualizados.getEmail());
           funcionarioAtual.setDataNascimento(funcionariosAtualizados.getDataNascimento());
           funcionarioAtual.setCargo(funcionariosAtualizados.getCargo());

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


