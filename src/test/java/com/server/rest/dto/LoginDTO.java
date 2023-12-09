package com.server.rest.dto;

import java.util.Locale;

import com.github.javafaker.Faker;

public class LoginDTO extends GeneralDTO {

	private String email;
	private String password;

	public LoginDTO(String email, String password) {

		this.email = email;
		this.password = password;
	}

	public LoginDTO(){

		Faker faker = new Faker(new Locale("pt-BR"));

		this.email = faker.internet().emailAddress();
		this.password = faker.internet().password();
	}

	public LoginDTO(UsuarioDTO usuarioDTO){
		this.email = usuarioDTO.getEmail();
		this.password = usuarioDTO.getPassword();
	}

	public String getEmail() {

		return email;
	}

	public String getPassword() {

		return password;
	}
}
