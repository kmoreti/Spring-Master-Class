/*
CREATE TABLE person
(
   id INTEGER NOT NULL,
   name VARCHAR(255) NOT NULL,
   location VARCHAR(255),
   birth_date TIMESTAMP,
   PRIMARY KEY(id)
);
*/

INSERT INTO PERSON (id, name, location, birth_date) 
VALUES(10001, 'Ranga', 'Hyderabad', sysdate());
INSERT INTO PERSON (id, name, location, birth_date) 
VALUES(10002, 'James', 'New York', sysdate());
INSERT INTO PERSON (id, name, location, birth_date) 
VALUES(10003, 'Pieter', 'Amsterdam', sysdate());