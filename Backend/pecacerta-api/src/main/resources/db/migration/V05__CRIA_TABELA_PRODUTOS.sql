CREATE TABLE produtos (
	prod_codigo serial NOT NULL,
	prod_codigo_de_barras CHAR(13) NOT NULL,
	prod_nome VARCHAR(50) NOT NULL,
	prod_descricao VARCHAR(100) NULL,
	prod_id_categoria INTEGER NULL,
	prod_id_marca INTEGER NULL,
	prod_preco DOUBLE PRECISION NOT NULL,
	prod_qtde_estoque INTEGER NOT NULL,
	CONSTRAINT produtos_pkey PRIMARY KEY (prod_codigo),
	CONSTRAINT produtos_prod_codigo_de_barras_key UNIQUE (prod_codigo_de_barras)
);

ALTER TABLE produtos ADD CONSTRAINT fk_categoria FOREIGN KEY (prod_id_categoria) REFERENCES categorias(cat_codigo);
ALTER TABLE produtos ADD CONSTRAINT fk_marca FOREIGN KEY (prod_id_marca) REFERENCES marcas(marca_codigo);