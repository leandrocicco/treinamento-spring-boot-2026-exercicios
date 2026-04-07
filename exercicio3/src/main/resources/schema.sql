-- Estas primiras linhas configuram o HSQLDB para trabalhar com schemas (databases) e simular o mysql
SET DATABASE SQL SYNTAX MYS TRUE;

DROP SCHEMA AP3_EXERCICIOS IF EXISTS CASCADE;

CREATE SCHEMA AP3_EXERCICIOS AUTHORIZATION DBA;

SET INITIAL SCHEMA AP3_EXERCICIOS;
SET DATABASE DEFAULT INITIAL SCHEMA AP3_EXERCICIOS;

-- ATENÇÃO: para usar nomes case-insentitive, precisa desabilitar um recurso do spring-data-jdbc.

CREATE TABLE ap3_exercicios.usuario(
    id              BIGINT          NOT NULL AUTO_INCREMENT,
    username        VARCHAR(50)     NOT NULL,
    nome            VARCHAR(200)    NOT NULL,
    idade           INT             NOT NULL,
    url_imagem      VARCHAR(1000)   NOT NULL,
    CONSTRAINT PK_USUARIO          PRIMARY KEY (id)
);

CREATE TABLE ap3_exercicios.post(
     id              BIGINT          NOT NULL AUTO_INCREMENT,
     data_postagem   TIMESTAMP       NOT NULL,
     mensagem        VARCHAR(2200)   NOT NULL,
     usuario_id      BIGINT          NOT NULL,
     CONSTRAINT PK_POST              PRIMARY KEY (id),
     CONSTRAINT PK_POST_USUARIO_ID   FOREIGN KEY (usuario_id) REFERENCES ap3_exercicios.usuario(id)
)

CREATE TABLE ap3_exercicios.post_tag(
     post_id           BIGINT          NOT NULL,
     nome              VARCHAR(255)    NOT NULL,
     ordem             INT             NOT NULL DEFAULT 0,
     CONSTRAINT PK_POST_TAG    PRIMARY KEY (post_id, nome),
     CONSTRAINT UK_POST_TAG_POST   FOREIGN KEY (post_id) REFERENCES ap3_exercicios.post(id)
);
