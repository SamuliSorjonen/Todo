CREATE DATABASE todo;

\c todo

CREATE TABLE todot(
    id SERIAL PRIMARY KEY, 
    tehtava varchar(250) NOT NULL);

INSERT INTO todot (tehtava) VALUES ('Siivoa huoneesi');
INSERT INTO todot (tehtava) VALUES ('Kirjoita kirje');