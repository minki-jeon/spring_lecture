USE jpa;

# Sample 1
DESC w3schools.Customers;
CREATE TABLE customer
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    customer_name VARCHAR(255),
    contact_name  VARCHAR(255),
    address       VARCHAR(255),
    city          VARCHAR(255),
    postal_code   VARCHAR(255),
    country       VARCHAR(255)
);
INSERT INTO customer (customer_name, contact_name, address, city, postal_code, country)
SELECT customername, contactname, address, city, postalcode, country
FROM w3schools.Customers;
SELECT * FROM jpa.customer;

# Sample 2
DESC w3schools.Employees;
CREATE TABLE employee
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    last_name  VARCHAR(255),
    first_name VARCHAR(255),
    birth_date DATE,
    photo      VARCHAR(255),
    notes      VARCHAR(5000)
);
INSERT INTO jpa.employee (last_name, first_name, birth_date, photo, notes)
SELECT LastName, FirstName, BirthDate, Photo, Notes
FROM w3schools.Employees;
SELECT * FROM jpa.employee;




DESC w3schools.Suppliers;
CREATE TABLE supplier(
    id INT AUTO_INCREMENT PRIMARY KEY,
    supplier_name VARCHAR(255),
    contact_name VARCHAR(255),
    address VARCHAR(255),
    city VARCHAR(255),
    postal_code VARCHAR(255),
    country VARCHAR(255),
    phone VARCHAR(255)
);
INSERT INTO supplier (supplier_name, contact_name, address, city, postal_code, country, phone)
SELECT suppliername,
       contactname,
       address,
       city,
       postalcode,
       country,
       phone
FROM w3schools.Suppliers;
SELECT * FROM supplier;