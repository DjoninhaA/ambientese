package com.Integrador.ambientese.model;

import java.io.File;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Entity
public class Empresa {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEmpresa;
	@Column(name = "razao_social", nullable = false)
    private String razaoSocial;
    @Column(name = "nome_fantasia", nullable = true)
    private String nomeFantasia;
    @Column(name = "cnpj", nullable = false)
    private String cnpj;
    @Column(name = "nome_solicitante", nullable = true)
    private String nomeSolicitante;
    @Column(name = "telefone_solicitante", nullable = true)
    private String telefoneSolicitante;
    @Column(name = "inscricao_social", nullable = true)
    private String inscricaoSocial;
    @Column(name = "ramo", nullable = false)
    private String ramo;
    @Column(name = "porte", nullable = false)
    private String porte;
    @Column(name = "logo", nullable = false)
    private File logo;
    @Column(name = "email", nullable = false)
    private String email;
    @Column(name = "telefone_empresa", nullable = false)
    private String telefoneEmpresa;

    
}
