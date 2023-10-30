CREATE SCHEMA sp_library;
SET SEARCH_PATH = 'sp_library';

CREATE TABLE IF NOT EXISTS userr (
    dni VARCHAR(8) PRIMARY KEY,
    name VARCHAR(100),
    lastname VARCHAR(100),
    email VARCHAR(100),
    password VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS book (
    id VARCHAR(8) PRIMARY KEY,
    title VARCHAR(100),
    author VARCHAR(255),
    genero VARCHAR(32),
    editorial VARCHAR(100),
    num_pages INTEGER,
    price DOUBLE PRECISION,
    units_stock BIGINT
);

CREATE TABLE IF NOT EXISTS buy (
    id VARCHAR(8) PRIMARY KEY,
    client VARCHAR(8),
    book_id VARCHAR(8),
    units INTEGER,
    time_buy TIMESTAMP,   -- tiempo current de compra
    refund_days INTEGER   -- dias habiles de reembolso
);

CREATE TABLE IF NOT EXISTS stand (
    book_id VARCHAR(8),
    owner VARCHAR(8),
    units INTEGER    -- se acumula la cantidad que tiene y cada fila es
                     -- un libro unico
);

ALTER TABLE buy ADD CONSTRAINT buy_fk_user FOREIGN KEY (client) REFERENCES userr(dni);
ALTER TABLE buy ADD CONSTRAINT buy_fk_book FOREIGN KEY (book_id) REFERENCES book(id);
ALTER TABLE stand ADD CONSTRAINT stand_fk_owner FOREIGN KEY (owner) REFERENCES userr(dni);
ALTER TABLE stand ADD CONSTRAINT stand_fk_book FOREIGN KEY (book_id) REFERENCES book(id);
