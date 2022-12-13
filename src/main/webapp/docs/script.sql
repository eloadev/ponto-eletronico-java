CREATE DATABASE IF NOT EXISTS dbpontoeletronico
	CHARACTER SET utf8mb4
	COLLATE utf8mb4_0900_ai_ci;

USE dbpontoeletronico;

CREATE TABLE departamento(
	departamento_id INT NOT NULL AUTO_INCREMENT,
	PRIMARY KEY(departamento_id),
	nome VARCHAR(255)
);
	
CREATE TABLE funcionario(
	funcionario_id INT NOT NULL AUTO_INCREMENT,
	PRIMARY KEY(funcionario_id),
	nome VARCHAR(255),
	cpf VARCHAR(255),
	email VARCHAR(255),
	senha VARCHAR(255),
	departamento_id INT NOT NULL,
	
	CONSTRAINT fk_departamento_id
	FOREIGN KEY (departamento_id)
	REFERENCES departamento (departamento_id)
);

CREATE TABLE ponto(
	ponto_id INT NOT NULL AUTO_INCREMENT,
	PRIMARY KEY(ponto_id),
	data VARCHAR(255),
	hora VARCHAR(255),
	funcionario_id INT,
	
	CONSTRAINT fk_funcionario_id
	FOREIGN KEY (funcionario_id)
	REFERENCES funcionario (funcionario_id)
);

CREATE TABLE administrador(
	administrador_id INT NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (administrador_id),
	nome VARCHAR(255),
	email VARCHAR(255),
	senha VARCHAR(255)
);

INSERT INTO administrador (nome, email, senha)
	VALUES ("Maria", "maria@gmail.com", "123"),
	("Vitor","vitor@gmail.com","123"),
	("Leonardo","leonardo@gmail.com","123");
INSERT INTO departamento (nome)
	VALUES ("rh"),
	("rc"),
	("marketing");
INSERT INTO funcionario (nome, cpf, email, senha, departamento_id)
	VALUES ("Elo","12312312312","elo@gmail.com","123",1),
	("Joao","32132132132","joao@gmail.com","123",2),
	("Marcio","11122233344","marcio@gmail.com","123",3);
INSERT INTO ponto (data, hora, funcionario_id)
	VALUES ("09 December 2022","18:11:23.516147529", 1),
	("10 December 2022","18:11:26.637028076",2),
	("11 December 2022","18:12:16.505506416",3);
