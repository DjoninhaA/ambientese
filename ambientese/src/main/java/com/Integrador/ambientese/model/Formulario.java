package com.Integrador.ambientese.model;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "resposta_usuario")
public class Formulario {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_formulario;
	@Column(name = "qtd_conformes", nullable = false)
	private String qtd_conformes;
	@Column(name = "data_preenchimento", nullable = false)
	private Date data_preenchimento;

	@OneToOne(optional = false)
	private Empresa empresa;

	@ManyToOne(optional = false)
	private Perguntas perguntas;

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Perguntas getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(Perguntas perguntas) {
		this.perguntas = perguntas;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_formulario;
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
		if (id_formulario != other.id_formulario)
			return false;
		return true;
	}
	
	public long getIdFormulario() {
		return id_formulario;
	}
	public void setIdFormulario(int idRespostaUsuario) {
		this.id_formulario = idRespostaUsuario;
	}
	public String getQtdConforme() {
		return qtd_conformes;
	}
	public void setQtdConforme(String resposta) {
		this.qtd_conformes = resposta;
	}
	public Date getDataPreenchimento() {
		return data_preenchimento;
	}

	public void setDataPreenchimento(Date data_preenchimento) {
		this.data_preenchimento = data_preenchimento;
	}
	
}
