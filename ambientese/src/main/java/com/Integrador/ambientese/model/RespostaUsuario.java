package com.Integrador.ambientese.model;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "RespostaUsuario")
public class RespostaUsuario {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRespostaUsuario;
	@Column(name = "Resposta", nullable = false)
	private String resposta;

	@OneToOne(cascade = CascadeType.REMOVE, optional = false)
	private Formulario formulario;

	@ManyToOne(optional = false)
	private Perguntas perguntas;
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idRespostaUsuario;
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
		RespostaUsuario other = (RespostaUsuario) obj;
		if (idRespostaUsuario != other.idRespostaUsuario)
			return false;
		return true;
	}
	
	public long getIdRespostaUsuario() {
		return idRespostaUsuario;
	}
	public void setIdRespostaUsuario(int idRespostaUsuario) {
		this.idRespostaUsuario = idRespostaUsuario;
	}
	public String getResposta() {
		return resposta;
	}
	public void setResposta(String resposta) {
		this.resposta = resposta;
	}
	
}
