package com.Integrador.ambientese.interfac;


import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;


import com.Integrador.ambientese.model.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    @Query("SELECT * FROM empresa WHERE nome_fantasia = ?1")
    Empresa findByNomeFantasia(String nome_fantasia);
}

