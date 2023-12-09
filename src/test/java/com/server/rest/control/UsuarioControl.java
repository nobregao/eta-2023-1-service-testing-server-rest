package com.server.rest.control;

public class UsuarioControl extends GeneralControl {

	private static UsuarioControl instance;

	private UsuarioControl(){
		endpoint = "/usuarios";
	}

	public static UsuarioControl getInstance(){
		if(instance == null)
			return new UsuarioControl();
		return instance;
	}

}
