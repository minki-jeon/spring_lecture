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
