CREATE DATABASE wildlife_tracker;
\c wildlife_tracker
CREATE TABLE sightings (id serial PRIMARY KEY, animalid int,location varchar,rangername varchar,lastseen timestamp);
CREATE TABLE animals (id serial PRIMARY KEY, name varchar,health varchar,age varchar, type varchar);
CREATE TABLE rangers (id serial PRIMARY KEY,name VARCHAR,badge_number INT);
CREATE DATABASE wildlife_tracker_test WITH TEMPLATE wildlife_tracker;

