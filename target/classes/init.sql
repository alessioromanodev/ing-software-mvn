DROP TABLE IF EXISTS riga_ordine;
DROP TABLE IF EXISTS ordine;
DROP TABLE IF EXISTS consegna;
DROP TABLE IF EXISTS pagamento;
DROP TABLE IF EXISTS newsletter;
DROP TABLE IF EXISTS fumetto;
DROP TABLE IF EXISTS utente;

CREATE TABLE utente (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    cognome VARCHAR(100) NOT NULL,
    username VARCHAR(100) UNIQUE NOT NULL,
    role VARCHAR(50),
    password VARCHAR(100) NOT NULL,
    email VARCHAR(150),
    indirizzo VARCHAR(255),
    registrato BOOLEAN
);

CREATE TABLE fumetto (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nome_serie VARCHAR(100),
    anno_serie VARCHAR(10),
    autore VARCHAR(100),
    numero_volume INT,
    titolo VARCHAR(150),
    genere VARCHAR(100),
    casa_editrice VARCHAR(100),
    immagine_copertina BLOB,
    descrizione TEXT,
    prezzo DECIMAL(10,2),
    quantita_disponibile INT
);

CREATE TABLE consegna (
    id_consegna INT PRIMARY KEY AUTO_INCREMENT,
    data_richiesta TIMESTAMP,
    data_consegna TIMESTAMP,
    stato VARCHAR(100)
);

CREATE TABLE ordine (
    id_ordine INT PRIMARY KEY AUTO_INCREMENT,
    data_ordine TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    importo_totale DECIMAL(10,2) NOT NULL,
    metodo_consegna VARCHAR(100),
    stato_ordine VARCHAR(100),
    qr_code VARCHAR(255)
);

CREATE TABLE riga_ordine (
    id_riga INT PRIMARY KEY AUTO_INCREMENT,
    quantita INT NOT NULL,
    prezzo_unitario DECIMAL(10,2) NOT NULL,
    fumetto_id INT NOT NULL,
    FOREIGN KEY (fumetto_id) REFERENCES fumetto(id)
);

CREATE TABLE pagamento (
    id_pagamento INT PRIMARY KEY AUTO_INCREMENT,
    data_pagamento TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    importo DECIMAL(10,2) NOT NULL,
    metodo VARCHAR(100),
    sconto_applicato BOOLEAN
);

CREATE TABLE newsletter (
    id_newsletter INT PRIMARY KEY AUTO_INCREMENT,
    titolo VARCHAR(255) NOT NULL,
    descrizione TEXT,
    data_creazione TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
