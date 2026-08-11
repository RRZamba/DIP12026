-- DDL (DATA DEFINITION LANGUAGE)

-- 1) Criando o Banco de dados
CREATE DATABASE FATEC_10_08;

-- 2) Selecionando o Banco de Dados
USE FATEC_10_08;

-- 3) Criando a tabela
CREATE TABLE sala_manufatura(
	id INT AUTO_INCREMENT,
	nome VARCHAR(45),
    semestre INT,
    endereco VARCHAR(45),
    PRIMARY KEY(id)
);

-- DML (DATA MANIPULATION LANGUAGE)

-- 1) Inserindo valores na tabela
INSERT INTO sala_manufatura(nome,semestre,endereco)
VALUES('Pedro',1,'Sto. André'),
	  ('Camila',2,'Sto. André'),
      ('Bruno',3,'SBC'),
      ('Yasmin',1,'Mauá'),
      ('Renato',1,'São Paulo');
      

-- 2) Selecionar todos os dados da tabela
SELECT * FROM sala_manufatura;

-- 3) Selecionando valores específicos 
SELECT id, nome, semestre
FROM sala_manufatura
WHERE semestre = 2;

SELECT * 
FROM sala_manufatura
WHERE endereco LIKE '%mau%'
AND semestre = 3;

-- 4) Atualizando registro
UPDATE sala_manufatura
SET semestre = 4
WHERE id = 7;
















