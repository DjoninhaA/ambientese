package com.Integrador.ambientese.interfac;

import org.springframework.data.jpa.repository.JpaRepository;


import com.Integrador.ambientese.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
        Empresa findByNomeFantasia(String nome_fantasia);
    
}

