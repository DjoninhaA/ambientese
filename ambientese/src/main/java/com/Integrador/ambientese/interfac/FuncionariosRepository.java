package com.Integrador.ambientese.interfac;

import com.Integrador.ambientese.model.Empresa;
import com.Integrador.ambientese.model.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

public interface FuncionariosRepository extends JpaRepository<Funcionarios, Long>, JpaSpecificationExecutor<Funcionarios> {
    Funcionarios findById(long idFuncionario);
}

