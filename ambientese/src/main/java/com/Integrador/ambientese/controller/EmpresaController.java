package com.Integrador.ambientese.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.Integrador.ambientese.interfac.EmpresaRepository;
import com.Integrador.ambientese.model.Empresa;
import com.Integrador.ambientese.model.Endereco;

@RestController
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping("/cadastroEmpresa")
    public ModelAndView editarEmpresa() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("html/cadastroEmpresa");
        return modelAndView;
     }

     @GetMapping("/editarEmpresa/{idEmpresa}")
    public ModelAndView cadastroEmperesa() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("html/cadastroEmpresa");
        return modelAndView;
     }

     @GetMapping("/listarEmpresa")
     public ModelAndView getEmpresas() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("html/listarEmpresa");
        return modelAndView;

     }

    @GetMapping("/buscaEmpresa/{nome_fantasia}")
    public ResponseEntity<Empresa> GetByName(@PathVariable String nome_fantasia){
        Empresa empresa = empresaRepository.findByNomeFantasia(nome_fantasia);
        return ResponseEntity.ok(empresa);
    }

    @GetMapping("/busca/{idEmpresa}")
    public ResponseEntity<Empresa> GetById(@PathVariable Long idEmpresa){
        Empresa empresa = empresaRepository.findByidEmpresa(idEmpresa);
        return ResponseEntity.ok(empresa);
    }

    @PostMapping("cadastroEmpresa")
    public ResponseEntity<String> saveEmpresa(
            @RequestParam("razao_social") String razaoSocial,
            @RequestParam("nome_fantasia") String nomeFantasia,
            @RequestParam("cnpj") Long cnpj,
            @RequestParam("nome_solicitante") String nomeSolicitante,
            @RequestParam("telefone_solicitante") String telefoneSolicitante,
            @RequestParam("inscricao_social") String inscricaoSocial,
            @RequestParam("ramo") String ramo,
            @RequestParam("porte") String porte,
            @RequestParam("logo") String logo,
            @RequestParam("cep") String cep,
            @RequestParam("numero") Integer numero,
            @RequestParam("cidade") String cidade,
            @RequestParam("estado") String estado,
            @RequestParam("pais") String pais,
            @RequestParam("logradouro") String logradouro,
            @RequestParam("email") String email,
            @RequestParam("telefone_empresa") Long telefoneEmpresa) {
    
        Empresa empresa = new Empresa();
        empresa.setRazaoSocial(razaoSocial);
        empresa.setNomeFantasia(nomeFantasia);
        empresa.setCnpj(cnpj);
        empresa.setNomeSolicitante(nomeSolicitante);
        empresa.setTelefoneSolicitante(telefoneSolicitante);
        empresa.setInscricaoSocial(inscricaoSocial);
        empresa.setRamo(ramo);
        empresa.setLogo(logo);
        empresa.setPorte(porte);
        empresa.setEmail(email);
        empresa.setTelefoneEmpresa(telefoneEmpresa);
    
        // Criar o objeto Endereco e configurar os dados
        Endereco enderecoEmpresa = new Endereco();
        enderecoEmpresa.setCep(String.valueOf(cep));
        enderecoEmpresa.setNumero(numero);
        enderecoEmpresa.setCidade(cidade);
        enderecoEmpresa.setLogradouro(logradouro);
        enderecoEmpresa.setUF(estado);
        enderecoEmpresa.setPais(pais);

        empresa.setEndereco(enderecoEmpresa);

        empresaRepository.save(empresa);
    
        return ResponseEntity.ok("Dados salvos com sucesso!");
    }

    @PutMapping("/atualizarPontuacao/{idEmpresa}")
    public ResponseEntity<String> atualizarPontuacao(
            @PathVariable long idEmpresa,
            @RequestParam("pontuacao") Float pontuacao) {

        return empresaRepository.findById(idEmpresa)
                .map(empresa -> {
                    empresa.setPontuacao(pontuacao);
                    empresaRepository.save(empresa);
                    return ResponseEntity.ok("Pontuação atualizada com sucesso!");
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/editar/{idEmpresa}")
    public ResponseEntity<String> atualizarEmpresa(
        @PathVariable long idEmpresa,
        @RequestParam("razao_social") String razaoSocial,
        @RequestParam("nome_fantasia") String nomeFantasia,
        @RequestParam("cnpj") Long cnpj,
        @RequestParam("nome_solicitante") String nomeSolicitante,
        @RequestParam("telefone_solicitante") String telefoneSolicitante,
        @RequestParam("inscricao_social") String inscricaoSocial,
        @RequestParam("ramo") String ramo,
        @RequestParam("porte") String porte,
        @RequestParam("logo") String logo,
        @RequestParam("cep") String cep,
        @RequestParam("numero") Integer numero,
        @RequestParam("cidade") String cidade,
        @RequestParam("estado") String estado,
        @RequestParam("pais") String pais,
        @RequestParam("email") String email,
        @RequestParam("logradouro") String logradouro,
        @RequestParam("telefone_empresa") Long telefoneEmpresa) {

    return empresaRepository.findById(idEmpresa)
            .map(empresa -> {
                empresa.setRazaoSocial(razaoSocial);
                empresa.setNomeFantasia(nomeFantasia);
                empresa.setCnpj(cnpj);
                empresa.setNomeSolicitante(nomeSolicitante);
                empresa.setTelefoneSolicitante(telefoneSolicitante);
                empresa.setInscricaoSocial(inscricaoSocial);
                empresa.setRamo(ramo);
                empresa.setLogo(logo);
                empresa.setPorte(porte);
                empresa.setEmail(email);
                empresa.setTelefoneEmpresa(telefoneEmpresa);

                Endereco enderecoEmpresa = empresa.getEndereco();
                if (enderecoEmpresa == null) {
                    enderecoEmpresa = new Endereco();
                }
                enderecoEmpresa.setCep(String.valueOf(cep));
                enderecoEmpresa.setNumero(numero);
                enderecoEmpresa.setCidade(cidade);
                enderecoEmpresa.setUF(estado);
                enderecoEmpresa.setPais(pais);
                enderecoEmpresa.setLogradouro(logradouro);
                empresa.setEndereco(enderecoEmpresa);

                empresaRepository.save(empresa);
                return ResponseEntity.ok("Empresa atualizada com sucesso!");
            })
            .orElse(ResponseEntity.notFound().build());
}

    @DeleteMapping("/deletar/{idEmpresa}")
        public void deletarEmpresa(@PathVariable Long idEmpresa){
            empresaRepository.deleteById(idEmpresa);
        }



}

