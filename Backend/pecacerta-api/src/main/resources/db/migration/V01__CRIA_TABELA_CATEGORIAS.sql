CREATE TABLE IF NOT EXISTS Categorias (
	cat_codigo SERIAL PRIMARY KEY,
	cat_nome VARCHAR(50) NOT NULL UNIQUE
);

INSERT INTO Categorias (cat_nome) VALUES('Pneu');
INSERT INTO Categorias (cat_nome) VALUES('Filtro');
INSERT INTO Categorias (cat_nome) VALUES('Carroçaria');
INSERT INTO Categorias (cat_nome) VALUES('Travões');
INSERT INTO Categorias (cat_nome) VALUES('Motor');
INSERT INTO Categorias (cat_nome) VALUES('Transmissão final');
INSERT INTO Categorias (cat_nome) VALUES('Suspensão');
INSERT INTO Categorias (cat_nome) VALUES('Sistema de limpeza dos vidros');
INSERT INTO Categorias (cat_nome) VALUES('Decoração interior');
INSERT INTO Categorias (cat_nome) VALUES('Correias de transmissão');
INSERT INTO Categorias (cat_nome) VALUES('Sistema de ignição');
INSERT INTO Categorias (cat_nome) VALUES('Direcção');
INSERT INTO Categorias (cat_nome) VALUES('Equipamentos eléctricos');
INSERT INTO Categorias (cat_nome) VALUES('Mangueiras e tubo flexível');
INSERT INTO Categorias (cat_nome) VALUES('Sistema de escape');
INSERT INTO Categorias (cat_nome) VALUES('Sistema de alimentação de combustível');
INSERT INTO Categorias (cat_nome) VALUES('Aquecimento / refrigeração');
INSERT INTO Categorias (cat_nome) VALUES('Ar condicionado');