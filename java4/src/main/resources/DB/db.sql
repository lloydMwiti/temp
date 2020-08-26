CREATE DATABASE animals;
\c animals;
create table IF NOT EXISTS people(
    id SERIAL primary key ,
    ranger VARCHAR,
    name VARCHAR ,
    health VARCHAR,
    age VARCHAR ,
    endangered VARCHAR,
    date VARCHAR,
    region VARCHAR
);
create table if not exists ranger(
    id serial primary key,
    name varchar,
    email varchar,
    badge varchar
)
