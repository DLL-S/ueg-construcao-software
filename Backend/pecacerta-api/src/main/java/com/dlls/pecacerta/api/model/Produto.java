package com.dlls.pecacerta.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Produtos")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prod_codigo")
	private Long codigo;
	
	@NotNull
	@Column(name = "prod_codigo_de_barras")
	private String codigoDeBarras;
	
	@NotNull
	@Column(name = "prod_nome")
	private String nome;
	
	
	@Column(name = "prod_descricao", nullable=true)
	private String descricao;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "prod_id_categoria")
	private Categoria categoria;
	
	@NotNull
	@ManyToOne
	@JoinColumn(name = "prod_id_marca")
	private Marca marca;
	
	@NotNull
	@Column(name = "prod_preco")
	private Double preco;
	
	@NotNull
	@Column(name = "prod_qtde_estoque")
	private Integer qtdeEstoque;
	
	public Produto() {
		
	}

	public Produto(Long codigo, String codigoDeBarras, String nome, String descricao, Categoria categoria,
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

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
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
