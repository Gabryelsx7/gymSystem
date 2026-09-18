INSERT INTO modalidades (nome)VALUES
('Musculacão'),
('Funcional'),
('Jiu-Jitsu'),
('Muay Thai'),
('Pilates');

INSERT INTO planos (modalidade_id, nome, valor_mensal)
SELECT id, 'MENSAL', 120.00 FROM modalidades where nome = 'Musculacão';

INSERT INTO planos (modalidade_id, nome, valor_mensal)
SELECT id, 'Trimestral', 330.00 FROM modalidades where nome = 'Musculacão';

INSERT INTO planos (modalidade_id, nome, valor_mensal)
SELECT id, 'Mensal', 330.00 FROM modalidades where nome = 'Funcional';

INSERT INTO planos (modalidade_id, nome, valor_mensal)
SELECT id, 'Mensal', 330.00 FROM modalidades where nome = 'Jiu-Jitsu';

INSERT INTO graduacoes (modalidade_id, nome)
SELECT id, 'Faixa Branca'FROM modalidades where nome = 'Jiu-jitsu';

INSERT INTO graduacoes (modalidade_id, nome)
SELECT id, 'Faixa Azul'FROM modalidades where nome = 'Jiu-jitsu';

INSERT INTO graduacoes (modalidade_id, nome)
SELECT id, 'Faixa Roxa'FROM modalidades where nome = 'Jiu-jitsu';
