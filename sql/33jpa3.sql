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


CREATE TABLE my_table22
(
    name    VARCHAR(20),
    address VARCHAR(20),
    country VARCHAR(20),
    primary key (name)
);
INSERT INTO my_table22(name, address, country)
VALUES ('kim', 'seoul', 'korea');
# INSERT 불가 (Primary Key를 입력하지않아서)
INSERT INTO my_table22 (address, country)
VALUES ('jeju', 'usa');

# 복합키
# DDL to Entity
CREATE TABLE my_table23
(
    name    VARCHAR(30),
    address VARCHAR(30),
    country VARCHAR(30),
    info    VARCHAR(30),
    PRIMARY KEY (name, address)
);
# Entity to DDL
CREATE TABLE my_table24
(
    email    VARCHAR(100) NOT NULL,
    password VARCHAR(50)  NOT NULL,
    score    INT          NULL,
    name     VARCHAR(20) NOT NULL,
    address  VARCHAR(200) NOT NULL,
    CONSTRAINT pk_my_table24 PRIMARY KEY (name, address)
);

# DDL to Entity
CREATE TABLE my_table25
(
    name         VARCHAR(30),
    class_name   VARCHAR(10),
    class_number INT,
    class_grade  VARCHAR(5),
    PRIMARY KEY (name, class_name)
);
# Entity to DDL
CREATE TABLE my_table26
(
    author     VARCHAR(255) NULL,
    price      INT          NULL,
    book_type  VARCHAR(255) NOT NULL,
    book_title VARCHAR(255) NOT NULL,
    CONSTRAINT pk_my_table26 PRIMARY KEY (book_type, book_title)
);


# 카테고리 정보
# foreign key (외래키, 참조키, FK)
CREATE TABLE my_table27
(
    id            INT PRIMARY KEY AUTO_INCREMENT,
    category_name VARCHAR(30),
    info          VARCHAR(1000)
);
# 상품 정보(카테고리 참조)
CREATE TABLE my_table28
(
    id           INT PRIMARY KEY AUTO_INCREMENT,
    product_name VARCHAR(30),
    price        INT,
    unit         VARCHAR(30),
    category_id  INT NOT NULL,
    FOREIGN KEY (category_id) REFERENCES my_table27 (id)
);

# 직원정보
CREATE TABLE my_table29
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(10),
    last_name  VARCHAR(10),
    birth_date DATE
);
# 주문정보(직원 참조)
CREATE TABLE my_table30
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    order_date  DATE,
    info        VARCHAR(20),
    employee_id INT,
    FOREIGN KEY (employee_id) REFERENCES my_table29 (id)
);
