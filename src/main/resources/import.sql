/* Corredores */
INSERT INTO corredor (nome, telefone, email, senha, data_nasc, cpf, endereco, genero, url_foto, pais_origem)
VALUES ('Ana Costa', '11999998888', 'ana@gmail.com', '123', '1988-08-22', '321.654.987-00', 'Rua dos Jardins, 200, São Paulo, SP', 'Feminino', 'http://example.com/fotos/ana.jpg', 'Brasil');

/* Empresas */
-- maratona da empresa cb@gmail.com
INSERT INTO empresa (nome, telefone, email, usuario, senha, cnpj, local, url_logo) 
VALUES ('Corridas do Brasil', '21911223344', 'cb@gmail.com', 'Fernanda Melo', '123', '33.222.111/0001-12', 'Av. Paulista, 1000, São Paulo, SP', 'http://example.com/logo/corridas.jpg');

/* Incrições */
-- maratona Corrida da Primavera pelo me@gmail.com podendo participar mas prescisa abrir com a empresa
INSERT INTO inscricao (id_corredor, id_maratona, forma_pagamento, status)
VALUES (2, 2, 'Cartão de Crédito', 'Inscrito');

/* Maratonas */
INSERT INTO maratona (criador, nome, local, data_inicio,data_final, distancia, status, descricao, regras, valor, tipo_terreno, clima_esperado)
VALUES (1, 'Maratona Internacional de São Paulo', 'São Paulo, SP', '2024-04-12','2025-11-12',  '42.195', 'Aberta', 'Uma das maiores provas do Brasil', 'Uso de chip e número obrigatório.', 180.00, 'Asfalto', 'Temperado');

/* Participações */
--dados da participação da terceira Inscrição que ja conclui a maratona e ela está fechada.
INSERT INTO participacao (id_inscricao, status_conclusao, tempo_registrado, tempo_inicio, tempo_fim, passos)
VALUES (3, 'Desativado', '4:00:00', '08:00:00', '12:00:00', 9000);