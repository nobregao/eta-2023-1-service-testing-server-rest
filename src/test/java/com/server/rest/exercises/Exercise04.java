package com.server.rest.exercises;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import com.server.rest.control.CarrinhoControl;
import com.server.rest.control.LoginControl;
import com.server.rest.control.ProdutoControl;
import com.server.rest.control.UsuarioControl;
import com.server.rest.dto.CarrinhoDTO;
import com.server.rest.dto.LoginDTO;
import com.server.rest.dto.ProdutoCarrinhoDTO;
import com.server.rest.dto.ProdutoDTO;
import com.server.rest.dto.UsuarioDTO;
import com.server.rest.util.Messages;

public class Exercise04 {

	@Test
	void test() {
		// cadastrar usuário
		UsuarioDTO usuarioDTO = new UsuarioDTO("true");
		String idUsuario = UsuarioControl.getInstance().post(usuarioDTO, HttpStatus.SC_CREATED, Messages.MESSAGE_OK);

		// autenticar usuario
		String token = LoginControl.getInstance().login(new LoginDTO(usuarioDTO), HttpStatus.SC_OK, Messages.MESSAGE_LOGIN_OK);

		// cadastrar produto
		Double preco = 50.00;
		Integer quantidade = 100;
		ProdutoDTO produtoDTO = ProdutoControl.createBeer(preco, quantidade);
		String idProduto = ProdutoControl.getInstance().postWithToken(produtoDTO, token, HttpStatus.SC_CREATED, Messages.MESSAGE_OK);

		// cadastrar carrinho
		CarrinhoDTO carrinhoDto = new CarrinhoDTO();
		ProdutoCarrinhoDTO produtoCarrinhoDto = new ProdutoCarrinhoDTO(idProduto, 2);
		carrinhoDto.getProdutos().add(produtoCarrinhoDto);
		CarrinhoControl.getInstance().postWithToken(carrinhoDto, token, HttpStatus.SC_CREATED, Messages.MESSAGE_OK);

		// excluir usuario - tentativa 1
		UsuarioControl.getInstance().delete(idUsuario, HttpStatus.SC_BAD_REQUEST, Messages.MESSAGE_USUARIO_DELETE_BAD_REQUEST);

		// concluir compra
		CarrinhoControl.getInstance().concluirCompra(token, HttpStatus.SC_OK);

		// excluir produto
		ProdutoControl.getInstance().deleteWithToken(idProduto, token, HttpStatus.SC_OK, Messages.MESSAGE_DELETE_OK);

		// excluir usuario - tentativa 2
		UsuarioControl.getInstance().delete(idUsuario, HttpStatus.SC_OK, Messages.MESSAGE_DELETE_OK);
	}
}
