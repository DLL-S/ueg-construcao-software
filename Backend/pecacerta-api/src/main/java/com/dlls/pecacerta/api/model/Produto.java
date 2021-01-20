package com.dlls.pecacerta.api.model;

public class Produto {
	
	private Integer codigo;
	private String codigoDeBarras;
	private String nome;
	private String descricao;
	private Categoria categoria;
	private Marca marca;
	private Double preco;
	private Integer qtdeEstoque;
	
	public Produto() {
		
	}

	public Produto(Integer codigo, String codigoDeBarras, String nome, String descricao, Categoria categoria,
			Marca marca, Double preco, Integer qtdeEstoque) {
		this.codigo = codigo;
		this.codigoDeBarras = codigoDeBarras;
		this.nome = nome;
		this.descricao = descricao;
		this.categoria = categoria;
		this.marca = marca;
		this.preco = preco;
		this.qtdeEstoque = qtdeEstoque;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getCodigoDeBarras() {
		return codigoDeBarras;
	}

	public void setCodigoDeBarras(String codigoDeBarras) {
		this.codigoDeBarras = codigoDeBarras;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQtdeEstoque() {
		return qtdeEstoque;
	}

	public void setQtdeEstoque(Integer qtdeEstoque) {
		this.qtdeEstoque = qtdeEstoque;
	}
}
