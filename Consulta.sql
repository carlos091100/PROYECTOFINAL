CREATE DATABASE IF NOT EXISTS contactos;

USE contactos;

CREATE TABLE contactos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(50),
  apellido VARCHAR(50),
  telefono VARCHAR(50),
  email VARCHAR(50)
);
