/* Corredores */
INSERT INTO corredor (data_nasc, cpf, email, endereco, genero, nome, pais_origem, senha, telefone, url_foto) VALUES ('1988-08-22', '321.654.987-00', 'ana@gmail.com', 'Rua dos Jardins, 200, São Paulo, SP', 'Feminino', 'Ana Costa', 'Brasil', '123', '11999998888', 'http://example.com/fotos/ana.jpg');

/* Empresas */
-- maratona da empresa cb@gmail.com
INSERT INTO empresa (data_criacao, cnpj, email, local, nome, senha, telefone, url_logo, usuario) VALUES (NOW(), '33.222.111/0001-12', 'cb@gmail.com', 'Av. Paulista, 1000, São Paulo, SP', 'Corridas do Brasil', '123', '21911223344', 'http://example.com/logo/corridas.jpg', 'Fernanda Melo');

/* Inscrições */
-- maratona Corrida da Primavera pelo me@gmail.com podendo participar mas prescisa abrir com a empresa
INSERT INTO inscricao (id_corredor, id_maratona, data_hora, forma_pagamento, status) VALUES (2, 2, NOW(), 'Cartão de Crédito', 'Inscrito');

/* Maratonas */
INSERT INTO maratona (criador, limite_participantes, valor, clima_esperado, data_final, data_inicio, descricao, regras, distancia, local, nome, nome_criador, status, tipo_terreno) VALUES (1, 10, 180.00, 'Temperado', '2025-11-12', '2024-04-12', 'Uma das maiores provas do Brasil', 'Uso de chip e número obrigatório.', '42.195', 'São Paulo, SP', 'Maratona Internacional de São Paulo', 'Fernanda Melo', 'Aberta para inscrição', 'Asfalto');

/* Participações */
-- dados da participação da terceira Inscrição que ja conclui a maratona e ela está fechada.
INSERT INTO participacao (id_inscricao, status_conclusao, tempo_registrado, tempo_inicio, tempo_fim, passos) VALUES (3, 'Desativado', '4:00:00', '08:00:00', '12:00:00', 9000);