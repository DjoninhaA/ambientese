package com.Integrador.ambientese.interfac;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Integrador.ambientese.model.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {
    Login findByUserName(String userName);
}

