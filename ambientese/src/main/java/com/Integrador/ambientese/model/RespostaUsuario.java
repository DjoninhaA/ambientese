package com.Integrador.ambientese.model;

import jakarta.persistence.*;

public class RespostaUsuario {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idRespostaUsuario;

}
