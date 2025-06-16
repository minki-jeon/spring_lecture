USE jpa;
# DB의 Table명과 컬럼명은 lower_snake_case 권장
CREATE TABLE my_table1
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    name     VARCHAR(30),
    city     VARCHAR(30),
    address VARCHAR(30)
);
INSERT INTO my_table1(name, city, address)
VALUES ('kim', 'seoul', '강남'),
       ('lee', 'busan', '신촌'),
       ('park', 'jeju', '명동'),
       ('choi', 'suwon', '마포'),
       ('son', 'dokdo', '홍대');
SELECT *
FROM my_table1;




CREATE TABLE my_table2
(
    id      INT AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(30),
    address VARCHAR(30),
    city    VARCHAR(30)
);
INSERT INTO my_table2 (name, address, city)
    SELECT name, address, city FROM my_table1;
SELECT * FROM my_table2;



CREATE TABLE my_table3
(
    id    INT AUTO_INCREMENT PRIMARY KEY,
    email VARCHAR(30),
    info  VARCHAR(30),
    nick  VARCHAR(30)
);
INSERT INTO my_table3 (email, info, nick) VALUES ('GMAIL', '어쩌구 저쩌구', 'trump');
SELECT * FROM my_table3;


ALTER TABLE my_table3 ADD COLUMN county VARCHAR(30);
ALTER TABLE my_table3
    CHANGE COLUMN county country VARCHAR(30);
# lower_snake_case
ALTER TABLE my_table3 ADD COLUMN home_address VARCHAR(30);


ALTER TABLE my_table3 ADD COLUMN work_address VARCHAR(30);


#
CREATE TABLE my_table4
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(30),
    score      DEC(10, 2),
    birth_date DATE,
    start_at   TIME,
    created_at DATETIME
);
INSERT INTO my_table4(name, score, birth_date, start_at, created_at)
VALUES ('trump', 33.12, '1999-09-09', '14:12:11', '1988-03-03 12:10:10');
SELECT * FROM my_table4;


CREATE TABLE my_table5
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    address     VARCHAR(30),
    hired_date  DATE,
    inserted_at DATETIME,
    height      DEC(10, 2),
    score       INT
);
INSERT INTO my_table5(address, hired_date, inserted_at, height, score)
VALUES ('뉴욕', '1976-09-10', '2025-01-02 17:19:22', 200.34, 567);

# DB Table to Entity 자동생성
CREATE TABLE my_table6
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    city        VARCHAR(30),
    score       DEC(10, 2),
    weight      BIGINT,
    birth_date  DATE,
    started_at  TIME,
    inserted_at DATETIME
);
CREATE TABLE my_table7
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    password    VARCHAR(30),
    name        VARCHAR(30),
    nickname    VARCHAR(30),
    point       BIGINT,
    birth_date  DATE,
    status      VARCHAR(10),
    login_count INT,
    created_at  DATETIME,
    updated_at  DATETIME,
    session_id  VARCHAR(50),
    use_yn      VARCHAR(1),
    del_yn      VARCHAR(1)
);


# Java Entity to SQL Query(DDL) 자동생성
CREATE TABLE my_table8
(
    id          INT AUTO_INCREMENT NOT NULL,
    address     VARCHAR(255)       NULL,
    salary      DEC(10, 2)             NULL,
    inserted_at datetime           NULL,
    hire_date   date               NULL,
    CONSTRAINT pk_my_table8 PRIMARY KEY (id)
);
CREATE TABLE my_table9
(
    id          INT AUTO_INCREMENT NOT NULL,
    password    VARCHAR(255)       NULL,
    name        VARCHAR(255)       NULL,
    nickname    VARCHAR(255)       NULL,
    point       BIGINT             NULL,
#     exp         DOUBLE             NULL,
    exp         DEC(5,2)           NULL,
    gender      CHAR               NULL,
    birth_date  date               NULL,
    status      VARCHAR(255)       NULL,
    login_count INT                NULL,
    created_at  datetime           NULL,
    updated_at  datetime           NULL,
    session_id  VARCHAR(255)       NULL,
    use_yn      CHAR               NULL,
    del_yn      CHAR               NULL,
    CONSTRAINT pk_my_table9 PRIMARY KEY (id)
);



CREATE TABLE my_table10
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(30),
    city       VARCHAR(30),
    birth_date DATE
);

select
    e1_0.id,
    e1_0.birth_date,
    e1_0.city,
    e1_0.name
from
    my_table10 e1_0
where
    e1_0.id=?;

SELECT * FROM my_table10 WHERE id = 1;

INSERT INTO my_table10 (name, city, birth_date) VALUE ('son', 'seoul', '1981-12-13');

CREATE TABLE my_table11
(
    id          INT PRIMARY KEY AUTO_INCREMENT,
    address     VARCHAR(30),
    score       DEC(10, 2),
    inserted_at DATETIME
);


CREATE TABLE my_table14
(
    id    INT AUTO_INCREMENT NOT NULL,
    name  VARCHAR(255)       NULL,
    score DEC(10, 2)         NULL,
    city  VARCHAR(255)       NULL,
    CONSTRAINT pk_my_table14 PRIMARY KEY (id)
);

INSERT INTO my_table14 (name, score, city)
VALUES
    ('kim', 88.8, 'seoul'),
    ('lee', 77.7, 'jeju'),
    ('park', 33.3, 'busan');
SELECT * FROM my_table14;

CREATE TABLE my_table15
(
    id          INT AUTO_INCREMENT NOT NULL,
    address     VARCHAR(255)       NULL,
    price       INT                NULL,
    inserted_at datetime           NULL,
    CONSTRAINT pk_my_table15 PRIMARY KEY (id)
);