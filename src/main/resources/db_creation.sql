CREATE DATABASE my_ticket_service_db;

CREATE TABLE users (
user_id INTEGER PRIMARY KEY UNIQUE,
name VARCHAR(50) NOT NULL,
creation_date TIMESTAMP NOT NULL);

CREATE TYPE ticket_type AS ENUM ('DAY', 'WEEK', 'MONTH', 'YEAR');

CREATE TABLE tickets (
ticket_id INTEGER PRIMARY KEY,
user_id INTEGER,
ticket_type ticket_type,
creation_date TIMESTAMP NOT NULL,
FOREIGN KEY (user_id) REFERENCES users (user_id) ON DELETE CASCADE);