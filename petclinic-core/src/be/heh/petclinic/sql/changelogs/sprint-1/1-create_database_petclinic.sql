--liquibase formatted sql

--changeset adrilaumax:1

CREATE DATABASE petclinic CHARACTER SET utf8 COLLATE utf8_general_ci;
GRANT SELECT, INSERT, UPDATE, DELETE ON petclinic.* to 'petclinic'@'%' IDENTIFIED BY 'petclinic';