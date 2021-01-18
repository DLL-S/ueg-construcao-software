CREATE TABLE IF NOT EXISTS Categorias (
	codigo SERIAL PRIMARY KEY,
	nome VARCHAR(50) NOT NULL UNIQUE
);

INSERT INTO Categorias (nome) VALUES('Filtro');
INSERT INTO Categorias (nome) VALUES('Carroçaria');
INSERT INTO Categorias (nome) VALUES('Travões');
INSERT INTO Categorias (nome) VALUES('Motor');
INSERT INTO Categorias (nome) VALUES('Transmissão final');
INSERT INTO Categorias (nome) VALUES('Suspensão');
INSERT INTO Categorias (nome) VALUES('Sistema de limpeza dos vidros');
INSERT INTO Categorias (nome) VALUES('Decoração interior');
INSERT INTO Categorias (nome) VALUES('Correias de transmissão');
INSERT INTO Categorias (nome) VALUES('Sistema de ignição');
INSERT INTO Categorias (nome) VALUES('Direcção');
INSERT INTO Categorias (nome) VALUES('Equipamentos eléctricos');
INSERT INTO Categorias (nome) VALUES('Mangueiras e tubo flexível');
INSERT INTO Categorias (nome) VALUES('Sistema de escape');
INSERT INTO Categorias (nome) VALUES('Sistema de alimentação de combustível');
INSERT INTO Categorias (nome) VALUES('Aquecimento / refrigeração');
INSERT INTO Categorias (nome) VALUES('Ar condicionado');
