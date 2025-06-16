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

