USE jpa;

SELECT COUNT(*) FROM customer;

INSERT INTO customer (customer_name, contact_name, address, city, postal_code, country)
SELECT customer_name, contact_name, address, city, postal_code, country FROM customer;


select count(*) from customer where country = 'mexico';
select count(*) from customer where id = 1;
select * from customer ;


CREATE TABLE my_table20
(
    name  VARCHAR(30),
    money INT,
    PRIMARY KEY (name)
);
INSERT INTO my_table20(name, money)
VALUES ('a', 10000),
       ('b', 10000);


CREATE TABLE my_table21
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    name        VARCHAR(20),
    address     VARCHAR(20),
    inserted_at DATETIME NOT NULL DEFAULT NOW()
);
INSERT INTO my_table21(name, address)
VALUES ('lee', 'seoul');

SELECT * FROM my_table21;

INSERT INTO my_table21(name, address)
VALUES ('kim', 'busan');

