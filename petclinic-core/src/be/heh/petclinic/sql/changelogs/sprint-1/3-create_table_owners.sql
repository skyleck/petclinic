--liquibase formatted sql

--changeset adrilaumax:3

USE petclinic;

CREATE TABLE IF NOT EXISTS owners (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  firstname VARCHAR(30),
  lastname VARCHAR(30),
  address VARCHAR(255),
  city VARCHAR(80),
  telephone VARCHAR(20)
);