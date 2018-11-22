DROP TABLE IF EXISTS owner;

CREATE TABLE owner (
    id int NOT NULL AUTO_INCREMENT,
    lastname varchar(45) not null,
    firstname varchar(45) not null,
    address varchar(45) not null,
    city varchar(45) not null,
    telephone varchar(45) not null,
    pets varchar(200) not null,
    primary key (id));

INSERT INTO owner (lastname, firstname, address,city,telephone,pets)
VALUES ("Franklin","George","10 W.Liberty St.","Madison","6085551023","Grandma Kaa Leo");

INSERT INTO owner (lastname, firstname, address,city,telephone,pets)
VALUES ("Davis","Betty","638 Cardinal Ave.","Sun Prairie","6085551749","Basil");

INSERT INTO owner (lastname, firstname, address,city,telephone,pets)
VALUES ("Rodriquez","Eduardo","2693 Commerce St.","McFarland", "6085558763","Jewel Rosy");
