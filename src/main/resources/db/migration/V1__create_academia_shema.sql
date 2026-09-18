CREATE TABLE alunos(
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL ,
    data_nascimento DATE,
    sexo VARCHAR(1) CHECK ( sexo in ('M','F')),
    telefone varchar(30),
    celular varchar(30) unique NOT NULL ,
    email varchar(30) unique NOT NULL ,
    observacao TEXT,
    endereco varchar(150),
    numero varchar(20),
    complemento VARCHAR(100),
    bairro varchar(100),
    cidade varchar(100),
    estado varchar(2),
    cep varchar(20),
    criado_em TIMESTAMP NOT NULL default CURRENT_TIMESTAMP,
    atualizado_em TIMESTAMP
);

CREATE TABLE modalidades(
    id BIGSERIAL PRIMARY KEY,
    nome varchar(100) NOT NULL unique,
    ativa BOOLEAN NOT NULL default true
);

CREATE TABLE graduacoes(
    id BIGSERIAL primary key,
    modalidade_id BIGINT NOT NULL REFERENCES modalidades(id),
    nome VARCHAR(100) NOT NULL,
    UNIQUE(modalidade_id, nome)
);
CREATE TABLE planos(
  id BIGSERIAL PRIMARY KEY,
modalidade_id BIGINT NOT NULL REFERENCES modalidades(id),
    nome varchar(100) NOT NULL,
    valor_mensal NUMERIC(10,2) NOT NULL CHECK ( valor_mensal >= 0),
    ativo BOOLEAN NOT NULL DEFAULT TRUE,
    UNIQUE (modalidade_id, nome)
);
CREATE TABLE matriculas(
    id BIGSERIAL PRIMARY KEY,
    aluno_id BIGINT  NOT NULL REFERENCES alunos(id),
    data_matricula DATE NOT NULL DEFAULT CURRENT_DATE,
    dia_vencimento Integer not null CHECK ( dia_vencimento BETWEEN 1 AND 31),
    data_encerramento DATE,
    status VARCHAR(20) NOT NULL DEFAULT 'ATIVA',
    check ( status in ('ATIVA', 'ENCERRADA','CANCELADA'))
);
CREATE TABLE matriculas_modalidades(
    id BIGSERIAL PRIMARY KEY,
    matricula_id BIGINT NOT NULL REFERENCES matriculas(id),
    modalidades_id BIGINT NOT NULL REFERENCES modalidades(id),
    graduacoes_id BIGINT NOT NULL REFERENCES graduacoes(id),
    plano_id BIGINT NOT NULL REFERENCES planos(id),
    data_inicio DATE NOT NULL  DEFAULT CURRENT_DATE,
    data_fim DATE,
    UNIQUE (matricula_id,modalidades_id)
);
CREATE TABLE faturas_matriculas(
    id BIGSERIAL PRIMARY KEY,
    matricula_id BIGINT NOT NULL REFERENCES matriculas(id),
    data_vencimento DATE NOT NULL ,
    valor NUMERIC(10,2) not null check ( valor >= 0 ),
    data_pagamento Timestamp,
    data_cancelamento date,
    status varchar(20) not null default 'ABERTA',
    check ( status in ('ABERTA','CANCELADA', 'PAGA','VENCIDA') ),
    unique(matricula_id,data_vencimento)
);
CREATE TABLE acessos_catraca(
    id BIGSERIAL PRIMARY KEY,
    matricula_id BIGINT NOT NULL REFERENCES matriculas (id),
    data_entrada TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_saida TIMESTAMP
);