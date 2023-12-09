package com.server.rest.exercises;

import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import com.server.rest.control.CarrinhoControl;
import com.server.rest.control.LoginControl;
import com.server.rest.control.ProdutoControl;
import com.server.rest.control.UsuarioControl;

import com.server.rest.dto.LoginDTO;
import com.server.rest.dto.UsuarioDTO;
import com.server.rest.util.Messages;
import com.server.rest.dto.CarrinhoDTO;
import com.server.rest.dto.ProdutoCarrinhoDTO;
import com.server.rest.dto.ProdutoDTO;

public class Exercise03 {

	@Test
	public void test(){
		// cadastrar usuario
		UsuarioDTO usuarioDTO = new UsuarioDTO("true");
		String idUsuario = UsuarioControl.getInstance().post(usuarioDTO, HttpStatus.SC_CREATED, Messages.MESSAGE_OK);

		// autenticar usuario
		String token = LoginControl.getInstance().login(new LoginDTO(usuarioDTO), HttpStatus.SC_OK, Messages.MESSAGE_LOGIN_OK);

		// cadastrar produto
		Double preco = 50.00;
		Integer quantidade = 100;
		ProdutoDTO produtoDTO = ProdutoControl.createBeer(preco, quantidade);
		String idProduto = ProdutoControl.getInstance().postWithToken(produtoDTO, token, HttpStatus.SC_CREATED, Messages.MESSAGE_OK);

		// verificar estoque do produto
		ProdutoControl.getInstance().verificarEstoque(idProduto, HttpStatus.SC_OK, 100);

		// cadastrar carrinho
		CarrinhoDTO carrinhoDto = new CarrinhoDTO();
		ProdutoCarrinhoDTO produtoCarrinhoDto = new ProdutoCarrinhoDTO(idProduto, 2);
		carrinhoDto.getProdutos().add(produtoCarrinhoDto);
		CarrinhoControl.getInstance().postWithToken(carrinhoDto, token, HttpStatus.SC_CREATED, Messages.MESSAGE_OK);

		// verificar estoque do produto
		ProdutoControl.getInstance().verificarEstoque(idProduto, HttpStatus.SC_OK, 98);

		// cancelar compra
		CarrinhoControl.getInstance().cancelarCompra(token, HttpStatus.SC_OK);

		// verificar estoque do produto
		ProdutoControl.getInstance().verificarEstoque(idProduto, HttpStatus.SC_OK, 100);

		// excluir produto
		ProdutoControl.getInstance().deleteWithToken(idProduto, token, HttpStatus.SC_OK, Messages.MESSAGE_DELETE_OK);

		// excluir usuario
		UsuarioControl.getInstance().delete(idUsuario, HttpStatus.SC_OK, Messages.MESSAGE_DELETE_OK);
	}

}
