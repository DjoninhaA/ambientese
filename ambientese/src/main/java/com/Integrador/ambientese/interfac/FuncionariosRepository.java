package com.Integrador.ambientese.interfac;

import com.Integrador.ambientese.model.Funcionarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionariosRepository extends JpaRepository<Funcionarios, Long> {
    Funcionarios findById(long idFuncionario);
}
