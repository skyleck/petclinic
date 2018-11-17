DROP TABLE IF EXISTS vet;

CREATE TABLE vet (
    id int NOT NULL AUTO_INCREMENT,
    lastname varchar(45) not null,
    firstname varchar(45) not null,
    speciality char(45) not null,
    primary key (id));

INSERT INTO vet (lastname, firstname, speciality)
VALUES ("Carter", "James", "none");

INSERT INTO vet (lastname, firstname, speciality)
VALUES ("Helen", "Leary", "radiology");

INSERT INTO vet (lastname, firstname, speciality)
VALUES ("Douglas", "Linda", "dentistry surgery");

INSERT INTO vet (lastname, firstname, speciality)
VALUES ("Ortega", "Rafael", "surgery");

INSERT INTO vet (lastname, firstname, speciality)
VALUES ("Stevens", "Henry","radiology");

INSERT INTO vet (lastname, firstname, speciality)
VALUES ("Jenkins", "Sharon","none");