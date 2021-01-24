CREATE TABLE Funcionarios (
	codigo SERIAL PRIMARY KEY,
	func_nome VARCHAR(60) NOT NULL,
	func_tipo_funcionario VARCHAR(20) NOT NULL,
	func_cpf VARCHAR(11) NOT NULL UNIQUE,
	func_data_nasc DATE NOT NULL,
	func_logradouro VARCHAR(40),
    func_numero VARCHAR(10),
    func_complemento VARCHAR(30),
    func_bairro VARCHAR(30),
    func_cep VARCHAR(10),
    func_cidade VARCHAR(30),
    func_estado varchar(30),
    func_email VARCHAR(40) NOT NULL,
    func_telefone VARCHAR(12) NOT NULL,
    func_senha_acesso VARCHAR NOT NULL
);

INSERT INTO Funcionarios (func_nome,func_tipo_funcionario,func_cpf,func_data_nasc,func_logradouro,func_numero,func_complemento,func_bairro,func_cep,func_cidade,func_estado,func_email,func_telefone,func_senha_acesso) VALUES ('Clio P. Wise','Atendente',54691578064,'2021-06-02','Ap #350-1754 Street',230,'624-3890 Urna St.','783-6687 Elit, St.','74.605-110','Sincelejo','Belize','netus.et.malesuada@commodoauctor.ca','40170706','NQB49TFF3VO');
INSERT INTO Funcionarios (func_nome,func_tipo_funcionario,func_cpf,func_data_nasc,func_logradouro,func_numero,func_complemento,func_bairro,func_cep,func_cidade,func_estado,func_email,func_telefone,func_senha_acesso) VALUES ('Martena Petty','Atendente',99219038021,'2021-01-02','P.O. Box 621, Road',438,'539-2246 Nam St.','2951 Suspendisse','11.400-102','Turnhout','Nigeria','tellus.Nunc@lacus.net','40556811','EDE13RVJ0AI');
INSERT INTO Funcionarios (func_nome,func_tipo_funcionario,func_cpf,func_data_nasc,func_logradouro,func_numero,func_complemento,func_bairro,func_cep,func_cidade,func_estado,func_email,func_telefone,func_senha_acesso) VALUES ('Jessamine Quinn','Gerente',71480034070,'2021-02-08','6057 At, Road',856,'P.O. Box 975','273-4065 Eleifend.','54.212-152','Haridwar','Curaçao','Quisque.purus@magnaDuis.ca','54763109','WRX23QXX6AJ');
INSERT INTO Funcionarios (func_nome,func_tipo_funcionario,func_cpf,func_data_nasc,func_logradouro,func_numero,func_complemento,func_bairro,func_cep,func_cidade,func_estado,func_email,func_telefone,func_senha_acesso) VALUES ('Merritt J. Pollard','Atendente',35262670067,'2021-05-04','2330 Tortor Avenue',668,'P.O. Box Avenue','7252 Sed, St.','38.400-128','Lanester','Martinique','lectus@justo.edu','87206438','SVY21JER6JJ');
