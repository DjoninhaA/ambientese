package com.Integrador.ambientese.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Integrador.ambientese.interfac.EmpresaRepository;
import com.Integrador.ambientese.model.Empresa;
import org.springframework.web.servlet.ModelAndView;

@RestController
//@RequestMapping("/empresa")
@Controller
public class CadastroempresaController {
    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping("/cadastro/empresa")
    public ModelAndView cadastroDeEmpresa() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("cadastroDeEmpresa");
        return modelAndView;
    } // Retorna o nome do arquivo HTML sem a extensão



    @GetMapping("/buscarTodas")
    public ResponseEntity<List<Empresa>>GetAll(){
        List<Empresa>allEmpresas = empresaRepository.findAll();
        return ResponseEntity.ok(allEmpresas);
    }

    @GetMapping("/buscarEmpresa/{nome_fantasia}")
    public ResponseEntity<Empresa> GetByName(@PathVariable String nome_fantasia){
        Empresa empresa = empresaRepository.findByNomeFantasia(nome_fantasia);
        return ResponseEntity.ok(empresa);
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<Empresa> PostEmpresa(@RequestBody Empresa empresa){
        empresaRepository.save(empresa);
            return ResponseEntity.ok(empresa);
    }


    @PutMapping("/editar/{idEmpresa}")
    public Empresa atualizarEmpresa(@PathVariable long idEmpresa, @RequestBody Empresa empresaAtualizada){
        return empresaRepository.findById(idEmpresa)
        .map(empresa -> {
            empresa.setEmail(empresaAtualizada.getEmail());
            empresa.setRazaoSocial(empresaAtualizada.getRazaoSocial());
            empresa.setCnpj(empresa.getCnpj());
            empresa.setNomeSolicitante(empresa.getNomeSolicitante());
            empresa.setTelefoneSolicitante(empresa.getTelefoneSolicitante());
            empresa.setInscricaoSocial(empresa.getInscricaoSocial());
            empresa.setRamo(empresa.getRamo());
            empresa.setPorte(empresa.getPorte());
            empresa.setEmail(empresa.getEmail());
            empresa.setTelefoneEmpresa(empresa.getTelefoneEmpresa());        
            return empresaRepository.save(empresa);
    })
    .orElseThrow(() -> new RuntimeException("Empresa não encontrada com o ID: " + idEmpresa));
}

    @DeleteMapping("/deletar/{idEmpresa}")
        public void deletarEmpresa(@PathVariable Long idEmpresa){
            empresaRepository.deleteById(idEmpresa);
        }



}

