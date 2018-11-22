DROP TABLE IF EXISTS pet;

CREATE TABLE pet (
	id int NOT NULL AUTO_INCREMENT,
	name varchar(45) not null,
	birthdate date not null,
	typepet varchar(30) not null,
	ownerId int NOT NULL,
	primary key (id)
);

INSERT INTO pet (name, birthdate, typepet,ownerId)
VALUES ("Grandma","2000-01-01","cat",1);

INSERT INTO pet (name, birthdate, typepet,ownerId)
VALUES ("Kaa","2018-10-25","snake",1);

INSERT INTO pet (name, birthdate, typepet,ownerId)
VALUES ("Leo","2010-09-07","hamster",1);

INSERT INTO pet (name, birthdate, typepet,ownerId)
VALUES ("Basil","2012-08-06","hamster",2);

INSERT INTO pet (name, birthdate, typepet,ownerId)
VALUES ("Jewel","2010-03-07","dog",3);

INSERT INTO pet (name, birthdate, typepet,ownerId)
VALUES ("Rosy","2011-04-17","dog",3);