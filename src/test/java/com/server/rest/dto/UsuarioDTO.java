package com.server.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "_id" })
public class UsuarioDTO extends GeneralDTO {

	private String nome;
	private String email;
	private String password;
	private String administrador;

	public UsuarioDTO(){

	}

	public UsuarioDTO(String nome, String email, String password, String administrador) {
		this.nome = nome;
		this.email = email;
		this.password = password;
		this.administrador = administrador;
	}

	public UsuarioDTO(String administrador) {

		this.nome = faker.name().fullName();
		this.email = faker.name().firstName().toLowerCase().concat("@qa.faker.br");
		this.password = faker.internet().password();
		this.administrador = administrador;
	}

	public String getNome() {

		return nome;
	}

	public void setNome(String nome) {

		this.nome = nome;
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {

		this.email = email;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword(String password) {

		this.password = password;
	}

	public String getAdministrador() {

		return administrador;
	}

	public void setAdministrador(String administrador) {

		this.administrador = administrador;
	}

}
