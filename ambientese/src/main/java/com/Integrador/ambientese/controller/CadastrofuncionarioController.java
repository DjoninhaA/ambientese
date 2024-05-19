package com.Integrador.ambientese.controller;


import com.Integrador.ambientese.model.Funcionarios;
import com.Integrador.ambientese.model.enums.Cargo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import com.Integrador.ambientese.interfac.FuncionariosRepository;

import java.util.Date;
import java.util.List;



@RestController
public class CadastrofuncionarioController {

    @Autowired
    private FuncionariosRepository funcionariosRepository;

    @GetMapping("/cadastroFuncionario")
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

    @PostMapping("/cadastrar/funcionario")
    public ResponseEntity<Funcionarios> postFuncionarios(@RequestBody Funcionarios funcionarios){
        Funcionarios savedFuncionario = funcionariosRepository.save(funcionarios);
        return ResponseEntity.ok(savedFuncionario);
    }

    @PostMapping("cadastroFuncionario")
    public ResponseEntity<String> saveFuncionario(
            @RequestParam("nome") String nome,
            @RequestParam("cpf") String cpf,
            @RequestParam("dataNascimento") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataNascimento,
            @RequestParam("cargo") String cargo,
            @RequestParam("email") String email,
            //@RequestParam("login") String login,
            //@RequestParam("senha") String senha,
            @RequestParam("telefone") String telefone) {

        Funcionarios funcionario = new Funcionarios();
        funcionario.setName(nome);
        funcionario.setCpf(cpf);
        funcionario.setDataNascimento(new java.sql.Date(dataNascimento.getTime()));
        funcionario.setCargo(Cargo.valueOf(cargo.toUpperCase())); // Ajuste para enum
        funcionario.setEmail(email);
        //funcionario.setLogin(login);
        //funcionario.setSenha(senha);
        funcionario.setTelefone(telefone);

        funcionariosRepository.save(funcionario);

        return ResponseEntity.ok("Dados salvos com sucesso!");
    }



    @PutMapping("/edit/{idFuncionario}")
    public Funcionarios atualizarFuncionarios(@RequestBody Funcionarios funcionariosAtualizados, @PathVariable long idFuncionario){
       try {
           Funcionarios funcionarioAtual = funcionariosRepository.findById(idFuncionario);
           funcionarioAtual.setName(funcionariosAtualizados.getName());
           funcionarioAtual.setCpf(funcionariosAtualizados.getCpf());
           funcionarioAtual.setEmail(funcionariosAtualizados.getEmail());
           funcionarioAtual.setTelefone(funcionariosAtualizados.getTelefone());
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


