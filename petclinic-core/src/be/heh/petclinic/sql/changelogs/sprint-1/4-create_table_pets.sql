--liquibase formatted sql

--changeset adrilaumax:4

USE petclinic;

CREATE TABLE IF NOT EXISTS pets (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(30),
  birthdate DATE,
  pettype VARCHAR(30),
  owner_id INT(4) UNSIGNED NOT NULL,
  FOREIGN KEY (owner_id) REFERENCES owners(id)
);