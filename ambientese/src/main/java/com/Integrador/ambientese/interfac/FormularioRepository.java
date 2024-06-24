package com.Integrador.ambientese.interfac;


import com.Integrador.ambientese.model.Formulario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormularioRepository extends JpaRepository<Formulario, Integer> {
}
