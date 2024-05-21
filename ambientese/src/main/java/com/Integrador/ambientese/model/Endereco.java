package com.Integrador.ambientese.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

    
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEndereco;
    @Column(name = "CEP", nullable = false)
    private String cep;
    @Column(name = "numero", nullable = false)
    private int numero;
    @Column(name = "complemento")
    private String complemento;
    @Column(name = "cidade", nullable = false)
    private String cidade;
    @Column(name = "UF", nullable = false)
    private String UF;
    @Column(name = "pais", nullable = false)
    private String pais;
}

