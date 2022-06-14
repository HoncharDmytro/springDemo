CREATE DATABASE music2db;

CREATE SEQUENCE hibernate_sequence START 1;

CREATE TABLE music2db.public.singer (
    id SERIAL NOT NULL PRIMARY KEY,
    first_name VARCHAR(60) NOT NULL,
    last_name VARCHAR(40) NOT NULL,
    birth_date DATE,
    version INT NOT NULL DEFAULT 0,
    UNIQUE(first_name, last_name));

CREATE TABLE music2db.public.album (
    id SERIAL NOT NULL PRIMARY KEY,
    singer_id INT NOT NULL,
    title VARCHAR(100) NOT NULL,
    release_date DATE,
    version INT NOT NULL DEFAULT 0,
    CONSTRAINT fk_album_singer FOREIGN KEY (singer_id) REFERENCES singer (id),
    UNIQUE (singer_id, title)
);

CREATE TABLE music2db.public.instrument (
    instrument_id VARCHAR(20) NOT NULL PRIMARY KEY
);

CREATE TABLE music2db.public.singer_instrument (
    singer_id INT NOT NULL,
    instrument_id VARCHAR(20) NOT NULL,
    PRIMARY KEY (singer_id, instrument_id),
    CONSTRAINT fk_singer_instrument_1 FOREIGN KEY (singer_id) REFERENCES singer (id) ON DELETE CASCADE,
    CONSTRAINT fk_singer_instrument_2 FOREIGN KEY (instrument_id) REFERENCES instrument (instrument_id)
);