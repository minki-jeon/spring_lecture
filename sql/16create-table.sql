# DATABASE : 테이블을 모아놓은 공간
# CREATE DATABASE : 데이터베이스 생성
CREATE DATABASE mydatabase;

# database(schema) 사용
USE mydatabase;
USE w3schools;

# CREATE TABLE : 테이블 만들기
CREATE TABLE table1
(
    id int
);

# DROP TABLE : 테이블 삭제 (사용 시 주의할 것)
DROP TABLE table1;

# SELECT NOT USE DATABASE TABLE
SELECT * FROM w3schools.Customers;
SELECT * FROM mydatabase.table1;

# CREATE TABLE + INSERT DATA
CREATE TABLE table2 # 테이블명
( # 둥근괄호 안에서 [컬럼명 타입] 나열
    name    varchar(255),
    country varchar(255),
    phone   varchar(255)
);
INSERT INTO table2 (name, country, phone)
VALUES ('트럼프', '미국', '2323');
SELECT * FROM table2;

# 테이블명, 컬럼명 작성 규칙
# 소문자, _ (lower_snake_case)
CREATE TABLE my_table1
(
    name            VARCHAR(255),
    address         VARCHAR(255),
    last_name       VARCHAR(255),
    nick_name       VARCHAR(255),
    home_address    VARCHAR(255),
    my_work_address VARCHAR(255)
);

CREATE TABLE table3
(
    id      VARCHAR(255),
    name    VARCHAR(255),
    address VARCHAR(255),
    team    VARCHAR(255)
);
INSERT INTO table3 (id, name, address, team)
values ('id01', 'name01', 'addr01', 'team01');
INSERT INTO table3 (id, name, address, team)
values ('id02', 'name02', 'addr02', 'team02');
SELECT * FROM table3;

# DROP TABLE
DROP TABLE my_table1;
DROP TABLE table3;



