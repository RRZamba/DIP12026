CREATE DATABASE FatecMilGrau;

CREATE TABLE Aluno(
	id INT AUTO_INCREMENT,
    nome VARCHAR(45),
    endereco VARCHAR(200),
    curso VARCHAR(20),
    semestre VARCHAR(10),
    periodo VARCHAR(10),  
    PRIMARY KEY(id)
);

INSERT INTO ALUNO(nome,endereco,curso,
                  semestre,periodo)
VALUES('Breno','Mauá','Ballet','Primeiro','Manhã');

SELECT * FROM Aluno;









