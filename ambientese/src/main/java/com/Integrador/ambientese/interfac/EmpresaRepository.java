package com.Integrador.ambientese.interfac;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Integrador.ambientese.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
        Empresa findByNomeFantasia(String nome_fantasia);
    
}

