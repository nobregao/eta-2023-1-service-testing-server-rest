package com.server.rest.dto;

public class ProdutoCarrinhoDTO extends GeneralDTO {

	private String idProduto;
	private int quantidade;

	public ProdutoCarrinhoDTO(String idProduto, int quantidade) {
		this.idProduto = idProduto;
		this.quantidade = quantidade;
	}

	public String getIdProduto() {

		return idProduto;
	}

	public int getQuantidade() {

		return quantidade;
	}
}
