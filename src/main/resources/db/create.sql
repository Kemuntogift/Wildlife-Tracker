CREATE DATABASE wildlife_tracker;
\c wildlife_tracker
CREATE TABLE animals (id serial PRIMARY KEY, name varchar,type VARCHAR,health VARCHAR,age VARCHAR,sighted timestamp);
CREATE TABLE sightings (id serial PRIMARY KEY,animal_id INT,ranger_id INT,location_id INT,time TIMESTAMP);
CREATE TABLE rangers (id serial PRIMARY KEY,name VARCHAR,badge_number VARCHAR);
CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;