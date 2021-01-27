CREATE TABLE clientes (
	codigo SERIAL PRIMARY KEY,
	cli_nome VARCHAR(60) NOT NULL,
	cli_tipo_cliente VARCHAR(20) NOT NULL,
	cli_cpf_cnpj VARCHAR(14) NOT NULL UNIQUE,
	cli_data_nasc DATE NOT NULL,
	cli_logradouro VARCHAR(40),
    cli_numero VARCHAR(10),
    cli_complemento VARCHAR(30),
    cli_bairro VARCHAR(30),
    cli_cep VARCHAR(10),
    cli_cidade VARCHAR(30),
    cli_estado varchar(30),
    cli_email VARCHAR(40) NOT NULL,
    cli_telefone VARCHAR(12) NOT NULL
);

INSERT INTO clientes (cli_nome,cli_tipo_cliente,cli_cpf_cnpj,cli_data_nasc,cli_logradouro,cli_numero,cli_complemento,cli_bairro,cli_cep,cli_cidade,cli_estado,cli_email,cli_telefone) VALUES ('Clio P. Wise','PESSOA_JURIDICA',54691578064,'2021-06-02','Ap #350-1754 Street',230,'624-3890 Urna St.','783-6687 Elit, St.','74.605-110','Sincelejo','Belize','netus.et.malesuada@commodoauctor.ca','40170706');