package com.Integrador.ambientese.controller;

import com.Integrador.ambientese.interfac.EmpresaRepository;
import com.Integrador.ambientese.model.Empresa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.persistence.criteria.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BuscarempresaController {

    @Autowired
    private final EmpresaRepository empresaRepository;
    
    public BuscarempresaController(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @GetMapping("/empresas")
    public Page<Empresa> getEmpresas(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(required = false) String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder,
            @RequestParam(required = false) String ramo,
            @RequestParam(required = false) String porte,
            @RequestParam(required = false) String nome) {

        Pageable pageable;

        if (sortBy != null && !sortBy.isEmpty()) {
            Sort sort = sortOrder.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
            pageable = PageRequest.of(page, size, sort);
        } else {
            pageable = PageRequest.of(page, size);
        }

        // Criando um objeto Specification para adicionar condições de filtro dinâmico
        Specification<Empresa> spec = new Specification<Empresa>() {
            @SuppressWarnings("null")
            @Override
            public Predicate toPredicate(Root<Empresa> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();

                if (ramo != null && !ramo.isEmpty()) {
                    predicates.add(cb.equal(root.get("ramo"), ramo));
                }
                if (porte != null && !porte.isEmpty()) {
                    predicates.add(cb.equal(root.get("porte"), porte));
                }
                if (nome != null && !nome.isEmpty()) {
                    predicates.add(cb.like(cb.lower(root.get("razaoSocial")), "%" + nome.toLowerCase() + "%"));
                }

                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };

        return empresaRepository.findAll(spec, pageable);
    }


    @DeleteMapping("/empresas/{id}")
    public ResponseEntity<?> deleteEmpresa(@PathVariable Long id) {
        try {
            empresaRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/buscar-empresa")
    public String home() {
        return "buscarEmpresa";
    }
}


