package com.Integrador.ambientese.model;


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
    @Column(name = "nome_fantasia", nullable = false)
    private String nomeFantasia;
    @Column(name = "cnpj", nullable = false)
    private long cnpj;
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
    @Column(name = "email", columnDefinition = "varchar(100) default 'email'", nullable = false)
    private String email;
    @Column(name = "telefone_empresa",columnDefinition = "varchar(20) default 'telefone'", nullable = false)
    private long telefoneEmpresa;
    @Column(name = "pontuacao", nullable = true)
    private Float pontuacao;
    @Column(name = "logo", nullable = true)
    private String logo;

    /*          FK           */
    @OneToOne(cascade = CascadeType.ALL, optional = false)
    private Endereco endereco;

    // public Empresa(){ // Quando uma empresa for instanciada será vinculado o id de um endereço;
    //     Endereco endereco = new Endereco();
    //     fk_Endereco = (endereco.getId());
    // }
}
