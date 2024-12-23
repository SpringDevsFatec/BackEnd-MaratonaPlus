/* Empresas */
INSERT INTO empresa (nome, telefone, email, usuario, senha, cnpj, local, url_logo, data_criacao) VALUES ('Corridas do Brasil', '21911223344', 'cb@gmail.com', 'Fernanda Melo', '123', '33.222.111/0001-12', 'Av. Paulista, 1000, São Paulo, SP', 'http://example.com/logo/corridas.jpg', NOW());
INSERT INTO empresa (nome, telefone, email, usuario, senha, cnpj, local, url_logo, data_criacao) VALUES ('Desafio Run', '31999887766', 'rd@gmail.com', 'João Mendes', '123', '44.333.222/0001-23', 'Av. dos Esportes, 300, São Paulo, SP', 'http://example.com/logo/desafio.jpg', NOW());
INSERT INTO empresa (nome, telefone, email, usuario, senha, cnpj, local, url_logo, data_criacao) VALUES ('Viva Maratonas', '11988776655', 'vm@gmail.com', 'Juliana Andrade', '123', '55.444.333/0001-34', 'Rua da Corrida, 50, São Paulo, SP', 'http://example.com/logo/viva.jpg', NOW());
INSERT INTO empresa (nome, telefone, email, usuario, senha, cnpj, local, url_logo, data_criacao) VALUES ('Elite Runners', '21966554433', 'er@gmail.com', 'Carlos Santos', '123', '66.555.444/0001-45', 'Av. da Elite, 678, São Paulo, SP', 'http://example.com/logo/elite.jpg', NOW());
INSERT INTO empresa (nome, telefone, email, usuario, senha, cnpj, local, url_logo, data_criacao) VALUES ('Endurance Brasil', '31988771122', 'eb@gmail.com', 'Mariana Silva', '123', '77.666.555/0001-56', 'Av. Principal, 345, São Paulo, SP', 'http://example.com/logo/endurance.jpg', NOW());
INSERT INTO empresa (nome, telefone, email, usuario, senha, cnpj, local, url_logo, data_criacao) VALUES ('Gustavo Maratonas', '(11) 4002-8922', 'gucraft2@gmail.com', 'Guh1254', '123', '12.345.678/0001-90', 'São Paulo, SP', 'http://example.com/logo/endurance.jpg', NOW());

/* Maratonas */
INSERT INTO maratona (criador, nome, local, data_inicio, data_final, distancia, status, descricao, regras, limite_participantes, valor, tipo_terreno, clima_esperado) VALUES (3, 'Corrida da Primavera', 'Curitiba, PR', '2024-09-21', '2024-10-21', '10', 'ABERTA_PARA_INSCRICAO', 'A Corrida da Primavera é um evento vibrante e cheio de cores que marca a chegada da estação das flores.', 'Uso de tênis adequado obrigatório.', 10, 80.00, 'Trilha', 'Fresco');
INSERT INTO maratona (criador, nome, local, data_inicio, data_final, distancia, status, descricao, regras, limite_participantes, valor, tipo_terreno, clima_esperado) VALUES (4, 'Desafio da Montanha', 'Campos do Jordão, SP', '2023-12-15', '2024-01-15', '21', 'CONCLUIDA', 'Para os que buscam aventura e superação', 'Uso de roupas térmicas.', 10, 200.00, 'Montanha', 'Frio');
INSERT INTO maratona (criador, nome, local, data_inicio, data_final, distancia, status, descricao, regras, limite_participantes, valor, tipo_terreno, clima_esperado) VALUES (4, 'Desafio da Montanha Gelada', 'Campos do Jordão, SP', '2023-12-15', '2024-01-15', '21', 'CONCLUIDA', 'Para os que buscam aventura e superação', 'Uso de roupas térmicas.', 10, 200.00, 'Montanha', 'Frio');
INSERT INTO maratona (criador, nome, local, data_inicio, data_final, distancia, status, descricao, regras, limite_participantes, valor, tipo_terreno, clima_esperado) VALUES (5, 'Maratona Noturna', 'Fortaleza, CE', '2024-08-10', '2024-09-10', '5', 'ABERTA', 'A Maratona Noturna oferece uma experiência única de correr sob as estrelas.', 'Obrigatório uso de lanterna.', 10, 50.00, 'Asfalto', 'Quente');
INSERT INTO maratona (criador, nome, local, data_inicio, data_final, distancia, status, descricao, regras, limite_participantes, valor, tipo_terreno, clima_esperado) VALUES (1, 'Maratona Internacional de São Paulo', 'São Paulo, SP', '2024-04-12', '2025-11-12', '42.195', 'ABERTA', 'Uma das maiores provas do Brasil', 'Uso de chip e número obrigatório.', 10, 180.00, 'Asfalto', 'Temperado');
INSERT INTO maratona (criador, nome, local, data_inicio, data_final, distancia, status, descricao, regras, limite_participantes, valor, tipo_terreno, clima_esperado) VALUES (6, 'Gustavo Maratonas I', 'Belo Horizonte, MG', '2024-09-07', '2024-10-07', '42', 'ABERTA_PARA_INSCRICAO', 'Celebre a história do Brasil com a Maratona da Independência', 'Uso obrigatório de chip.', 10,120.00, 'Asfalto', 'Quente');
INSERT INTO maratona (criador, nome, local, data_inicio, data_final, distancia, status, descricao, regras, limite_participantes, valor, tipo_terreno, clima_esperado) VALUES (6, 'Gustavo Maratonas II', 'São Paulo, SP', '2024-09-07', '2024-10-07', '42', 'CANCELADA', 'Celebre a história do Brasil com a Maratona da Independência', 'Uso obrigatório de chip.', 10,120.00, 'Asfalto', 'Quente');

/* Corredores */
INSERT INTO corredor (nome, telefone, email, senha, data_nasc, cpf, endereco, genero, url_foto, pais_origem) VALUES ('Ana Costa', '11999998888', 'ana@gmail.com', '123', '1988-08-22', '321.654.987-00', 'Rua dos Jardins, 200, São Paulo, SP', 'Feminino', 'http://example.com/fotos/ana.jpg', 'Brasil');
INSERT INTO corredor (nome, telefone, email, senha, data_nasc, cpf, endereco, genero, url_foto, pais_origem) VALUES ('Carlos Mendes', '21987654321', 'me@gmail.com', '123', '1975-03-10', '111.222.333-44', 'Avenida Central, 101, São Paulo, SP', 'Masculino', 'http://example.com/fotos/carlos.jpg', 'Brasil');
INSERT INTO corredor (nome, telefone, email, senha, data_nasc, cpf, endereco, genero, url_foto, pais_origem) VALUES ('Fernanda Oliveira', '31965432109', 'fe@gmail.com', '123', '1995-07-18', '555.666.777-88', 'Rua das Laranjeiras, 456, São Paulo, SP', 'Feminino', 'http://example.com/fotos/fernanda.jpg', 'Brasil');
INSERT INTO corredor (nome, telefone, email, senha, data_nasc, cpf, endereco, genero, url_foto, pais_origem) VALUES ('Rafael Lima', '21911223344', 'raf@gmail.com', '123', '1993-11-05', '888.999.000-11', 'Rua das Palmeiras, 789, São Paulo, SP', 'Masculino', 'http://example.com/fotos/rafael.jpg', 'Brasil');
INSERT INTO corredor (nome, telefone, email, senha, data_nasc, cpf, endereco, genero, url_foto, pais_origem) VALUES ('Juliana Martins', '31987655443', 'ju@gmail.com', '123', '2000-02-12', '999.888.777-66', 'Rua Primavera, 345, São Paulo, SP', 'Feminino', 'http://example.com/fotos/juliana.jpg', 'Brasil');

/* Inscrições */
INSERT INTO inscricao (id_corredor, id_maratona, data_hora, forma_pagamento, status) VALUES (2, 4, '2024-11-21T15:56:02.796069', 'Cartão de Crédito', 'INSCRITO');
INSERT INTO inscricao (id_corredor, id_maratona, data_hora, forma_pagamento, status) VALUES (3, 1, '2024-11-21T15:56:02.796069', 'Boleto Bancário', 'INSCRITO');
INSERT INTO inscricao (id_corredor, id_maratona, data_hora, forma_pagamento, status) VALUES (4, 3, '2024-11-21T15:56:02.796069', 'PIX', 'FINALIZADO');
INSERT INTO inscricao (id_corredor, id_maratona, data_hora, forma_pagamento, status) VALUES (5, 4, '2024-11-21T15:56:02.796069', 'Cartão de Débito', 'INSCRITO');
INSERT INTO inscricao (id_corredor, id_maratona, data_hora, forma_pagamento, status) VALUES (1, 4, '2024-11-21T15:56:02.796069', 'Transferência Bancária', 'INSCRITO');
/*inscrição finalizada*/
INSERT INTO inscricao (id_corredor, id_maratona, data_hora, forma_pagamento, status) VALUES (1, 3, '2024-11-21T14:56:02.796069', 'PIX', 'FINALIZADO');
INSERT INTO inscricao (id_corredor, id_maratona, data_hora, forma_pagamento, status) VALUES (2, 3, '2024-11-21T15:56:02.796069', 'PIX', 'FINALIZADO');
INSERT INTO inscricao (id_corredor, id_maratona, data_hora, forma_pagamento, status) VALUES (3, 3, '2024-11-21T16:56:02.796069', 'PIX', 'FINALIZADO');


/* Participações */
INSERT INTO participacao (id_inscricao, status_conclusao, tempo_registrado, tempo_inicio,tempo_ingresso, tempo_fim, passos, velocidade_km, velocidade_ms) VALUES (3, 'DESISTENCIA', '1:30:00', '2000-02-12 12:00:00','2000-02-12 11:50:00', '2000-02-12 13:30:00', 9000, 22.0, 50.0);
INSERT INTO participacao (id_inscricao, status_conclusao, tempo_registrado, tempo_inicio,tempo_ingresso, tempo_fim, passos, velocidade_km, velocidade_ms) VALUES (6, 'FINALIZADO', '1:30:00', '2000-02-12 12:00:00','2024-11-27 11:50:00', '2000-02-12 13:30:00', 9000,30.0, 50.0);
INSERT INTO participacao (id_inscricao, status_conclusao, tempo_registrado, tempo_inicio,tempo_ingresso, tempo_fim, passos, velocidade_km, velocidade_ms) VALUES (7, 'FINALIZADO', '1:35:05', '2024-11-27 12:00:00','2024-11-27 11:50:00', '2000-02-12 13:35:05', 9000,29.0,45.0);
INSERT INTO participacao (id_inscricao, status_conclusao, tempo_registrado, tempo_inicio,tempo_ingresso, tempo_fim, passos, velocidade_km, velocidade_ms) VALUES (8, 'FINALIZADO', '1:36:10', '2024-11-27 12:00:00','2024-11-27 11:50:00', '2000-02-12 13:36:10', 9000,28.0, 40.0);

/* Ranking */
INSERT INTO ranking (id_corredor, id_maratona, posicao, tempo_total) VALUES (1, 3, 3, 5600);
INSERT INTO ranking (id_corredor, id_maratona, posicao, tempo_total) VALUES (2, 3, 2, 5500);
INSERT INTO ranking (id_corredor, id_maratona, posicao, tempo_total) VALUES (3, 3, 1, 5400);
INSERT INTO ranking (id_corredor, id_maratona, posicao, tempo_total) VALUES (4, 3, 4, 5400);

