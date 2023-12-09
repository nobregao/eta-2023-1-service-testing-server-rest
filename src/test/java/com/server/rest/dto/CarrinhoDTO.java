package com.server.rest.dto;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDTO extends GeneralDTO {

	private List<ProdutoCarrinhoDTO> produtos;

	public CarrinhoDTO(){
		this.produtos = new ArrayList<ProdutoCarrinhoDTO>();
	}

	public CarrinhoDTO(List<ProdutoCarrinhoDTO> produtos) {

		this.produtos = produtos;
	}

	public List<ProdutoCarrinhoDTO> getProdutos() {

		return produtos;
	}
}
