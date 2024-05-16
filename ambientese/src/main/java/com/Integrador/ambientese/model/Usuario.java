package com.Integrador.ambientese.model;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Table(name = "usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idUsuario;
	
	@Column(name = "login", nullable = false)
	private String login;
	@Column(name = "senha", nullable = false)
	private String senha;
	// @Column(name = "isAdmin", nullable = false)
	// private int isAdmin;
	
	// public long getIdUsuario() {
		// 	return idUsuario;
		// }
		
		// public void setIdUsuario(long idUsuario) {
			// 	this.idUsuario = idUsuario;
			// }
			
			@Override
			public int hashCode() {
				final int prime = 31;
				int result = 1;
				result = prime * result + (int) (idUsuario ^ (idUsuario >>> 32));
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
				Usuario other = (Usuario) obj;
				if (idUsuario != other.idUsuario)
					return false;
				return true;
			}
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
