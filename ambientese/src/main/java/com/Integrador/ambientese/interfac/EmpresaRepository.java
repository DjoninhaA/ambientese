package com.Integrador.ambientese.interfac;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.Integrador.ambientese.model.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long>, JpaSpecificationExecutor<Empresa> {
        Empresa findByNomeFantasia(String nomeFantasia);

        Empresa findByidEmpresa(Long idEmpresa);
}
