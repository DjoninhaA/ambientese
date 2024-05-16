package com.Integrador.ambientese.model;


import com.Integrador.ambientese.model.enums.Porte;
import com.Integrador.ambientese.model.enums.Ramo;
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
    private long cnpj;
    @Column(name = "nome_solicitante", nullable = true)
    private String nomeSolicitante;
    @Column(name = "telefone_solicitante", nullable = true)
    private String telefoneSolicitante;
    @Column(name = "inscricao_social", nullable = true)
    private String inscricaoSocial;
    @Enumerated(EnumType.STRING)
    @Column(name = "ramo", nullable = false)
    private Ramo ramo;
    @Enumerated(EnumType.STRING)
    @Column(name = "porte", nullable = false)
    private Porte porte;
    @Column(name = "email", columnDefinition = "varchar(100) default 'email'", nullable = false)
    private String email;
    @Column(name = "telefone_empresa",columnDefinition = "varchar(20) default 'telefone'", nullable = false)
    private long telefoneEmpresa;
    @Column(name = "pontuacao", nullable = true)
    private Float pontuacao;

    @Embedded
    private Endereco endereco;

}
