ALTER TABLE tb_gatos
    ADD COLUMN IF NOT EXISTS status_acolhimento VARCHAR(50) NOT NULL DEFAULT 'AGUARDANDO';

UPDATE tb_gatos SET status_acolhimento = 'AGUARDANDO' WHERE status_acolhimento IS NULL;

CREATE TABLE IF NOT EXISTS tb_doacoes (
    id BIGSERIAL PRIMARY KEY,
    valor NUMERIC(10, 2) NOT NULL,
    descricao VARCHAR(255),
    data_doacao TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT NOW()
);

CREATE TABLE IF NOT EXISTS tb_adocoes (
    id BIGSERIAL PRIMARY KEY,
    gato_id BIGINT REFERENCES tb_gatos(id),
    data_conclusao DATE,
    status VARCHAR(50) NOT NULL
);

CREATE TABLE IF NOT EXISTS tb_resgates (
    id BIGSERIAL PRIMARY KEY,
    data_resgate DATE NOT NULL,
    descricao TEXT,
    local VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS tb_atendimentos_veterinarios (
    id BIGSERIAL PRIMARY KEY,
    gato_id BIGINT REFERENCES tb_gatos(id),
    data_entrada DATE NOT NULL,
    data_saida DATE
);
