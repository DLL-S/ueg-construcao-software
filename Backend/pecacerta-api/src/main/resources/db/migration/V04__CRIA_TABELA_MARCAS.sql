CREATE TABLE IF NOT EXISTS Marcas (
	marca_codigo SERIAL PRIMARY KEY,
	marca_nome VARCHAR(50) NOT NULL UNIQUE
);

INSERT INTO Marcas (marca_nome) VALUES('LUK');
INSERT INTO Marcas (marca_nome) VALUES('Valeo');
INSERT INTO Marcas (marca_nome) VALUES('Autotec');
INSERT INTO Marcas (marca_nome) VALUES('BOSCH');
INSERT INTO Marcas (marca_nome) VALUES('Milestone');
INSERT INTO Marcas (marca_nome) VALUES('Pirelli');
INSERT INTO Marcas (marca_nome) VALUES('Bridgestone');