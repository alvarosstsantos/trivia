INSERT INTO jogador (nome, usuario, senha)
VALUES ('Roberval',  'rbrvl', '123');

INSERT INTO jogador (nome, usuario, senha)
VALUES ('Demerval',  'dmrvl', '321');

INSERT INTO pergunta (texto)
VALUES ('Qual bicho transmite doença de chagas?');

INSERT INTO alternativa (texto, eh_correta, pergunta_id)
VALUES ('Abelha', false, 1);

INSERT INTO alternativa (texto, eh_correta, pergunta_id)
VALUES ('Barata', false, 1);

INSERT INTO alternativa (texto, eh_correta, pergunta_id)
VALUES ('Pulga', false, 1);

INSERT INTO alternativa (texto, eh_correta, pergunta_id)
VALUES ('Barbeiro', true, 1);

INSERT INTO pergunta (texto)
VALUES ('Qual fruto é conhecido no Norte e Nordeste como jerimum?');

INSERT INTO alternativa (texto, eh_correta, pergunta_id)
VALUES ('Caju', false, 2);

INSERT INTO alternativa (texto, eh_correta, pergunta_id)
VALUES ('Abóbora', true, 2);

INSERT INTO alternativa (texto, eh_correta, pergunta_id)
VALUES ('Chuchu', false, 2);

INSERT INTO alternativa (texto, eh_correta, pergunta_id)
VALUES ('Côco', false, 2);

INSERT INTO pergunta (texto)
VALUES ('Qual é o coletivo de cães?');

INSERT INTO alternativa (texto, eh_correta, pergunta_id)
VALUES ('Matilha', true, 3);

INSERT INTO alternativa (texto, eh_correta, pergunta_id)
VALUES ('Rebanho', false, 3);

INSERT INTO alternativa (texto, eh_correta, pergunta_id)
VALUES ('Alcateia', false, 3);

INSERT INTO alternativa (texto, eh_correta, pergunta_id)
VALUES ('Manada', false, 3);

INSERT INTO pergunta (texto)
VALUES ('Qual é o triângulo que tem todos os lados diferentes?');

INSERT INTO alternativa (texto, eh_correta, pergunta_id)
VALUES ('Equilátero', false, 4);

INSERT INTO alternativa (texto, eh_correta, pergunta_id)
VALUES ('Isóceles', false, 4);

INSERT INTO alternativa (texto, eh_correta, pergunta_id)
VALUES ('Escaleno', true, 4);

INSERT INTO alternativa (texto, eh_correta, pergunta_id)
VALUES ('Trapézio', false, 4);

INSERT INTO partida (jogador_id)
VALUES (1);

INSERT INTO resposta (partida_id, pergunta_id, alternativa_id)
VALUES (1, 1, 1);

INSERT INTO resposta (partida_id, pergunta_id)
VALUES (1, 2);


