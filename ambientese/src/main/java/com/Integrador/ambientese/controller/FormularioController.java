package com.Integrador.ambientese.controller;

import com.Integrador.ambientese.interfac.EmpresaRepository;
import com.Integrador.ambientese.interfac.FormularioRepository;
import com.Integrador.ambientese.interfac.PerguntasRepository;
import com.Integrador.ambientese.model.Empresa;
import com.Integrador.ambientese.model.Formulario;
import com.Integrador.ambientese.model.Perguntas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;


@RestController
public class FormularioController {
    @Autowired
    private PerguntasRepository perguntasRepository;

    @Autowired
    private FormularioRepository formularioRepository;

    @Autowired
    private EmpresaRepository empresaRepository;
    @GetMapping("/formulario/{idEmpresa}")
    public ModelAndView formulario() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("html/formularioEmpresa");
        return modelAndView;
    }
    @PostMapping("/salvarFormulario")
    public ResponseEntity<?> salvarFormulario(@RequestParam Long empresaId, @RequestParam Long perguntasId,
                                              @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dataPreenchimento, @RequestParam String qtdConformes) {
        try {


            Empresa empresa = empresaRepository.findById(empresaId)
                    .orElseThrow(() -> new RuntimeException("Empresa não encontrada"));

            Perguntas perguntas = perguntasRepository.findById(perguntasId)
                    .orElseThrow(() -> new RuntimeException("Perguntas não encontrada"));

            Formulario formulario = new Formulario();
            formulario.setEmpresa(empresa);
            formulario.setPerguntas(perguntas);
            formulario.setDataPreenchimento(new java.sql.Date(dataPreenchimento.getTime()));
            formulario.setQtdConforme(qtdConformes);
            formularioRepository.save(formulario);

            return ResponseEntity.ok("Formulário salvo com sucesso!");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Erro ao salvar o formulário: " + e.getMessage());
        }
    }
    @GetMapping("/perguntas")
    public List<Perguntas> getAllPerguntas() {
        return perguntasRepository.findAll();
    }

    @GetMapping("/relatorio/{id}")
    public ModelAndView relatorioAndView() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("html/relatorio");
        return modelAndView;
    }

}
