package com.server.rest.control;

import com.server.rest.dto.LoginDTO;

public class LoginControl extends GeneralControl {

	private final String PARAMETER_AUTHORIZATION = "authorization";

	private static LoginControl instance;

	private LoginControl(){
		endpoint = "/login";
	}

	public static LoginControl getInstance() {
		if (instance == null)
			return new LoginControl();
		return instance;
	}

	public String login(LoginDTO dto, int statusCode, String message) {
		return postDefault(dto, statusCode, message, null, PARAMETER_AUTHORIZATION);
	}

}
