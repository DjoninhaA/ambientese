package com.Integrador.ambientese.model;

import java.sql.Date;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "RespostaUsuario")
public class Formulario {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idFormulario;
	@Column(name = "qtd_conformes", nullable = false)
	private String qtdConforme;
	@Column(name = "data_preenchimento", nullable = false)
	private Date dataPreenchimento;

	@OneToOne(optional = false)
	private Empresa empresa;

	@ManyToOne(optional = false)
	private Perguntas perguntas;
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idFormulario;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Formulario other = (Formulario) obj;
		if (idFormulario != other.idFormulario)
			return false;
		return true;
	}
	
	public long getIdFormulario() {
		return idFormulario;
	}
	public void setIdFormulario(int idRespostaUsuario) {
		this.idFormulario = idRespostaUsuario;
	}
	public String getQtdConforme() {
		return qtdConforme;
	}
	public void setQtdConforme(String resposta) {
		this.qtdConforme = resposta;
	}
	
}
