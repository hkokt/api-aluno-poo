CREATE DATABASE escola;
use escola;
CREATE TABLE alunos
(
    id_aluno uuid UNIQUE NOT NULL,
    nascimento DATE,
    ra         varchar(30),
    nome       varchar(100)
);
