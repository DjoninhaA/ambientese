package com.Integrador.ambientese.model;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

    
@NoArgsConstructor
@Getter
@Setter
@Embeddable
public class Endereco {
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

