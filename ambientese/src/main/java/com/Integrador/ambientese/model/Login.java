package com.Integrador.ambientese.model;

import jakarta.persistence.*;

import java.util.Objects;



@Entity
public class Login {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "userName", nullable = false)
	private String userName;
	@Column(name = "password", nullable = false)
	private String password;
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id, userName, password);
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
		
}
