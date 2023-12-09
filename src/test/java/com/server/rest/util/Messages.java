package com.server.rest.util;

public interface Messages {

	String MESSAGE_OK = "Cadastro realizado com sucesso";
	String MESSAGE_DELETE_OK = "Registro excluído com sucesso";

	String MESSAGE_LOGIN_OK = "Login realizado com sucesso";
	String MESSAGE_LOGIN_INVALID = "Email e/ou senha inválidos";

	String MESSAGE_USUARIO_CADASTRO_BAD_REQUEST = "Este email já está sendo usado";
	String MESSAGE_CARRINHO_PRODUTO_REABASTECIDO_OK = "Registro excluído com sucesso. Estoque dos produtos reabastecido";
	String MESSAGE_USUARIO_DELETE_BAD_REQUEST = "Não é permitido excluir usuário com carrinho cadastrado";

}
