--liquibase formatted sql

--changeset adrilaumax:5

USE petclinic;

CREATE TABLE IF NOT EXISTS visits (
  id INT(4) UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY,
  pet_id INT(4) UNSIGNED NOT NULL,
  vet_id INT(4) UNSIGNED NOT NULL,
  visitdate DATE,
  description VARCHAR(255),
  FOREIGN KEY (pet_id) REFERENCES pets(id),
  FOREIGN KEY (vet_id) REFERENCES vets(id)
);