CREATE TABLE tb_cidade(
    id_cidade bigint NOT NULL PRIMARY KEY,
    nome varchar(50) NOT NULL,
    qtd_habitantes bigint
);

INSERT INTO tb_cidade
    (id_cidade, nome, qtd_habitantes)
VALUES
    (1, 'São Paulo', 12396372),
    (2, 'Rio de Janeiro', 1000000),
    (3, 'Fortaleza', 8000000),
    (4, 'Natal', 900000),
    (5, 'Goiânia', 153000),
    (6, 'Rio Claro', 4412000),
    (7, 'Manaus', 3690000),
    (8, 'Rio Branco', 8000158);