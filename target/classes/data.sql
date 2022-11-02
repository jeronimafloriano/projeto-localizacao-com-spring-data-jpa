CREATE TABLE tb_cidade(
    id_cidade bigint NOT NULL PRIMARY KEY,
    nome varchar(50) NOT NULL,
    qtd_habitantes bigint
);

INSERT INTO tb_cidade
    (id_cidade, nome, qtd_habitantes)
VALUES
    (1, 'São Paulo', 82396372),
    (2, 'Rio de Janeiro', 72396372),
    (3, 'Fortaleza', 62396372),
    (4, 'Natal', 52396372),
    (5, 'Goiânia', 42396372),
    (6, 'Rio Claro', 32396372),
    (7, 'Manaus', 22396372),
    (8, 'Rio Branco', 12396372),
    (9, 'Pontalina', 1396372);