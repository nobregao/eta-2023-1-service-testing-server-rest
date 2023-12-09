package com.server.rest.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "_id" })
public class ProdutoDTO extends GeneralDTO {

	private String nome;
	private Double preco;
	private String descricao;
	private int quantidade;

	public ProdutoDTO(){

	}

	public ProdutoDTO(String nome, Double preco, String descricao, int quantidade) {

		this.nome = nome;
		this.preco = preco;
		this.descricao = descricao;
		this.quantidade = quantidade;
	}

	public String getNome() {

		return nome;
	}

	public Double getPreco() {

		return preco;
	}

	public String getDescricao() {

		return descricao;
	}

	public int getQuantidade() {

		return quantidade;
	}
}
