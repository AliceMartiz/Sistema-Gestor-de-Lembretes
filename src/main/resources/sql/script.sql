
CREATE TABLE Usuario(
                        nome varchar,
                        senha varchar,
                        id serial primary key
)
CREATE TABLE Categoria(
                          nome varchar,
                          descricao varchar,
                          id_usu int references Usuario(id),
                          id serial primary key
)
CREATE TABLE Lembrete(
                         titulo varchar,
                         prioridade int,
                         status int,
                         nivelEsforco int,
                         data date,
                         id_usu int references Usuario(id),
                         id_categoria int references Categoria(id),
                         id serial primary key
)

select * from Lembrete
select * from Categoria
select * from Usuario

select * from Lembrete where id_categ

select * from Usuario where nome = 'pipoca' and senha = 'pipoca'
select * from Categoria where id_usu = 5
select * from Categoria where id_usu = 5 and id = 1


drop table Usuario
drop table Categoria
drop table Lembrete

    INSERT INTO Usuario (nome, senha) VALUES
    ('Alice', '12345'),
    ('Joao', 'admin123');

INSERT INTO Categoria (nome, descricao, 1) VALUES
                                               ('Faculdade', 'Trabalhos, provas e projetos da UCDB'),
                                               ('Trabalho', 'Tarefas do estágio e reuniões'),
                                               ('Pessoal', 'Lembretes de saúde, lazer e casa');

DELETE FROM Usuario WHERE id = 3

select * from Usuario where nome = 'blu'