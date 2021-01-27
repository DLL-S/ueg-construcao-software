CREATE TABLE produtos (
	prod_codigo SERIAL NOT NULL,
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

INSERT INTO produtos(prod_codigo_de_barras, prod_nome, prod_descricao, prod_id_categoria, prod_id_marca, prod_preco, prod_qtde_estoque) VALUES ('1245897632541', 'Pneu Turanza', 'Pneus de verão Bridgestone Turanza ER 300', 1, 7, 349, 4);
INSERT INTO produtos(prod_codigo_de_barras, prod_nome, prod_descricao, prod_id_categoria, prod_id_marca, prod_preco, prod_qtde_estoque) VALUES ('1548965472356', 'Pneu Cinturato Winter', 'Pneus de inverno Pirelli Cinturato Winter', 1, 6, 399, 8);
INSERT INTO produtos(prod_codigo_de_barras, prod_nome, prod_descricao, prod_id_categoria, prod_id_marca, prod_preco, prod_qtde_estoque) VALUES ('1325478965120', 'Filtro de ar', 'Cartucho filtrante', 2, 4, 89, 20);