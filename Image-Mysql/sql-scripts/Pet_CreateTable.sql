DROP TABLE IF EXISTS pet;

CREATE TABLE pet (
	id int NOT NULL AUTO_INCREMENT,
	name varchar(45) not null,
	birthdate date not null,
	typepet varchar(30) not null,
	primary key (id)
);