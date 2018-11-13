--liquibase formatted sql

--changeset adrilaumax:2

USE petclinic;

CREATE TABLE IF NOT EXISTS vets (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(30),
  last_name VARCHAR(30),
  speciality VARCHAR(30),
  INDEX(last_name)
) engine=InnoDB