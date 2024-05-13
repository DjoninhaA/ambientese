package com.Integrador.ambientese.interfac;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Integrador.ambientese.model.Usuario;

public interface LoginRepository extends JpaRepository<Usuario, Long> {
    Usuario findByLogin(String login);
}

