CREATE DATABASE animals;
\c animals;
create table IF NOT EXISTS people(
    id SERIAL primary key ,
    ranger VARCHAR,
    name VARCHAR ,
    health VARCHAR,
    age VARCHAR ,
    endangered VARCHAR
)