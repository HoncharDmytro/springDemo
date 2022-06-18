CREATE DATABASE IF NOT EXISTS musicdb6;

CREATE TABLE musicdb6.singer (
    id INT NOT NULL AUTO_INCREMENT
    , first_name VARCHAR(60) NOT NULL
    , last_name VARCHAR(40) NOT NULL
    , birth_date DATE
    , UNIQUE (first_name, last_name)
    , PRIMARY KEY (id)
);

CREATE TABLE musicdb6.album (
    id INT NOT NULL AUTO_INCREMENT
    , singer_id INT NOT NULL
    , title VARCHAR(100) NOT NULL
    , release_date DATE
    , UNIQUE (singer_id, title)
    , PRIMARY KEY (id)
    , CONSTRAINT fk_album FOREIGN KEY (singer_id) REFERENCES singer (id)
);