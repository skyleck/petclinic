DROP TABLE IF EXISTS pet;

CREATE TABLE pet (
	id int NOT NULL AUTO_INCREMENT,
	name varchar(45) not null,
	birthdate date not null,
	typepet varchar(30) not null,
	primary key (id)
);

INSERT INTO pet (name, birthdate, typepet)
VALUES ("Titi","2015-01-01","bird");

INSERT INTO pet (name, birthdate, typepet)
VALUES ("Tardos","2013-12-31","dog");

INSERT INTO pet (name, birthdate, typepet)
VALUES ("Buzz","2011-07-15","rabbit");