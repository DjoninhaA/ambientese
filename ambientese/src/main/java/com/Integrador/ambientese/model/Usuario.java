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
	@Column(name = "isAdmin", nullable = false)
	private int isAdmin;

	public long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
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

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Usuario usuario = (Usuario) o;
		return idUsuario == usuario.idUsuario && isAdmin == usuario.isAdmin && Objects.equals(login, usuario.login) && Objects.equals(senha, usuario.senha);
	}

	@Override
	public int hashCode() {
		return Objects.hash(idUsuario, login, senha, isAdmin);
	}
}
