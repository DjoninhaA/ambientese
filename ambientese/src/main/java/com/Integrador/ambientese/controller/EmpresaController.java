package com.Integrador.ambientese.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.Integrador.ambientese.interfac.EmpresaRepository;
import com.Integrador.ambientese.model.Empresa;
import com.Integrador.ambientese.model.Endereco;

@RestController
public class EmpresaController {

    @Autowired
    private EmpresaRepository empresaRepository;

    @GetMapping("/cadastroEmpresa")
    public ModelAndView cadastroEmperesa() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("html/cadastroEmpresa");
        return modelAndView;
     }

     @GetMapping("/buscar")
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
            @RequestParam("logo") MultipartFile logo,
            @RequestParam("cep") String cep,
            @RequestParam("endereco") String endereco,
            @RequestParam("numero") Integer numero,
            @RequestParam("cidade") String cidade,
            @RequestParam("estado") String estado,
            @RequestParam("pais") String pais,
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
        empresa.setPorte(porte);    
        empresa.setEmail(email);
        empresa.setTelefoneEmpresa(telefoneEmpresa);
    
        // Criar o objeto Endereco e configurar os dados
        Endereco enderecoEmpresa = new Endereco();
        enderecoEmpresa.setCep(String.valueOf(cep));
        enderecoEmpresa.setNumero(numero);
        enderecoEmpresa.setCidade(cidade);
        enderecoEmpresa.setUF(estado);
        enderecoEmpresa.setPais(pais);
    
        // Definir o endereço na empresa
        empresa.setEndereco(enderecoEmpresa);
    
        // Salvar a empresa no repositório
        empresaRepository.save(empresa);
    
        return ResponseEntity.ok("Dados salvos com sucesso!");
    }
    

    @PutMapping("/editar/{idEmpresa}")
    public ResponseEntity<Empresa> atualizarEmpresa(
            @PathVariable long idEmpresa, 
            @RequestBody Empresa empresaAtualizada) {
    
        return empresaRepository.findById(idEmpresa)
                .map(empresa -> {
                    empresa.setEmail(empresaAtualizada.getEmail());
                    empresa.setRazaoSocial(empresaAtualizada.getRazaoSocial());
                    empresa.setCnpj(empresaAtualizada.getCnpj());
                    empresa.setNomeSolicitante(empresaAtualizada.getNomeSolicitante());
                    empresa.setTelefoneSolicitante(empresaAtualizada.getTelefoneSolicitante());
                    empresa.setInscricaoSocial(empresaAtualizada.getInscricaoSocial());
                    empresa.setRamo(empresaAtualizada.getRamo());
                    empresa.setPorte(empresaAtualizada.getPorte());
                    empresa.setTelefoneEmpresa(empresaAtualizada.getTelefoneEmpresa());
    
                    Endereco enderecoAtualizado = empresaAtualizada.getEndereco();
                    Endereco enderecoEmpresa = empresa.getEndereco();
    
                    if (enderecoEmpresa == null) {
                        enderecoEmpresa = new Endereco();
                    }
    
                    enderecoEmpresa.setCep(enderecoAtualizado.getCep());
                    enderecoEmpresa.setNumero(enderecoAtualizado.getNumero());
                    enderecoEmpresa.setCidade(enderecoAtualizado.getCidade());
                    enderecoEmpresa.setUF(enderecoAtualizado.getUF());
                    enderecoEmpresa.setPais(enderecoAtualizado.getPais());
                    empresa.setEndereco(enderecoEmpresa);
    
                    Empresa empresaSalva = empresaRepository.save(empresa);
                    return ResponseEntity.ok(empresaSalva);
                })
                .orElseThrow(() -> new RuntimeException("Empresa não encontrada com o ID: " + idEmpresa));
    }
    

    @DeleteMapping("/deletar/{idEmpresa}")
        public void deletarEmpresa(@PathVariable Long idEmpresa){
            empresaRepository.deleteById(idEmpresa);
        }



}

