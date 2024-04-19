package com.Integrador.ambientese.model;

import jakarta.persistence.*;

public class Resposta {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRespostaUsuario;
	@Column(name = "Resposta", nullable = false)
	private Resposta resposta;

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
		Resposta other = (Resposta) obj;
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
	public Resposta getResposta() {
		return resposta;
	}
	public void setResposta(Resposta resposta) {
		this.resposta = resposta;
	}
	
}
