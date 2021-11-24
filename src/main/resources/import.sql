--password: daniel
insert into usuario(id, email, nome, senha, ativo) values (1, 'danielfarias09@hotmail.com', 'Daniel Farias','$2a$10$kMGxJBLMME9VZZnFMSMKsuZzYh0AF/Fczgxg6Z5dAwo9YtOgnxAQK', true);
insert into permissao(id, nome_permissao, usuario_id) values (2, 'ROLE_USER', 1);


insert into imovel(id, descricao, preco, tipo) values (1, 'Apartamento T2 em Lisboa', 1000.0, 'APARTAMENTO');
insert into imovel(id, descricao, preco, tipo) values (2, 'Apartamento T1 em Aveiro', 500.0, 'APARTAMENTO');
insert into imovel(id, descricao, preco, tipo) values (3, 'Moradia T5', 1500.0, 'CASA');
insert into imovel(id, descricao, preco, tipo) values (4, 'Escritório no centro do Porto', 900.0, 'ESCRITÓRIO');