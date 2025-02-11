CREATE DATABASE library;
USE library;

CREATE TABLE books(
    isbn INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    year_published INT NOT NULL
);