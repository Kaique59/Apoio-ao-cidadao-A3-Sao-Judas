CREATE DATABASE IF NOT EXISTS apoio_ao_cidadao;
USE apoio_ao_cidadao;

CREATE TABLE tb_funcionario (
    id INT PRIMARY KEY AUTO_INCREMENT,
    login VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL
);

CREATE TABLE tb_cidadaos (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(200) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    telefone VARCHAR(20),
    endereco TEXT
);

CREATE TABLE tb_necessidades (
    id INT PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(200) NOT NULL,
    status VARCHAR(100) DEFAULT 'não atendido'
);
