package com.server.rest.test;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import com.server.rest.util.Messages;
import com.server.rest.control.UsuarioControl;
import com.server.rest.dto.UsuarioDTO;

public class UsuarioTest {

	@Test
	public void testListar(){
		UsuarioControl.getInstance().list();
	}

	@Test
	public void testCadastrarComSucesso(){

		UsuarioDTO dto = new UsuarioDTO("true");

		String id = UsuarioControl.getInstance().post(dto, HttpStatus.SC_CREATED, Messages.MESSAGE_OK);

		UsuarioControl.getInstance().delete(id, HttpStatus.SC_OK, Messages.MESSAGE_DELETE_OK);
	}

	@Test
	public void testCadastrarEmailDuplicado(){

		UsuarioDTO dto = new UsuarioDTO("true");

		String id = UsuarioControl.getInstance().post(dto, HttpStatus.SC_CREATED, Messages.MESSAGE_OK);

		UsuarioControl.getInstance().post(dto, HttpStatus.SC_BAD_REQUEST, Messages.MESSAGE_USUARIO_CADASTRO_BAD_REQUEST);

		UsuarioControl.getInstance().delete(id, HttpStatus.SC_OK, Messages.MESSAGE_DELETE_OK);
	}

}
