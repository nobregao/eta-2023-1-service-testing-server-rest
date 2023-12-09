package com.server.rest.test;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import com.server.rest.control.LoginControl;
import com.server.rest.dto.LoginDTO;
import com.server.rest.util.Messages;

public class LoginTest {

	@Test
	public void testLoginSucesso(){

		LoginDTO dto = new LoginDTO("fulano@qa.com", "teste");

		LoginControl.getInstance().login(dto, HttpStatus.SC_OK, Messages.MESSAGE_LOGIN_OK);
	}

	@Test
	public void testLoginInvalido() {

		LoginDTO dto = new LoginDTO();

		LoginControl.getInstance().login(dto, HttpStatus.SC_UNAUTHORIZED, Messages.MESSAGE_LOGIN_INVALID);
	}

}
