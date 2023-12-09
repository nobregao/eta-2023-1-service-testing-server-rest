package com.server.rest.control;

import java.util.Locale;

import com.github.javafaker.Faker;
import com.server.rest.dto.ProdutoDTO;

public class ProdutoControl extends GeneralControl {

	private static ProdutoControl instance;

	private ProdutoControl(){
		endpoint = "/produtos";
	}

	public static ProdutoControl getInstance() {
		if (instance == null)
			return new ProdutoControl();
		return instance;
	}

	public ProdutoDTO verificarEstoque(String id, int statusCode, Integer expected){
		return getValidParameter(id, statusCode, "quantidade", expected).as(ProdutoDTO.class);
	}

	public static ProdutoDTO createBeer(Double preco, Integer quantidade){
		String nome = new Faker(new Locale("pt-BR")).beer().name();
		String descricao = "beer";

		return new ProdutoDTO(nome, preco, descricao, quantidade);
	}

}
