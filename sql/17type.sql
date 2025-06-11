USE mydatabase;

# STRING
#    VARCHAR(길이)
CREATE TABLE table4
(
    col1 VARCHAR(1),
    col2 VARCHAR(3),
    col3 VARCHAR(5)
);
INSERT INTO table4(col1, col2, col3)
VALUES ('a', 'abc', 'abcde');
INSERT INTO table4(col1, col2, col3)
VALUES ('한', 'abc', 'abcde');
# [22001][1406] Data truncation: Data too long for column 'col1' at row 1
INSERT INTO table4(col1, col2, col3)
VALUES ('ab', 'abc', 'abcde');
INSERT INTO table4(col1, col2, col3)
VALUES ('한글', 'abc', 'abcde');
SELECT * FROM table4;

# id (최대 8자), name(최대 20자) 컬럼이 있는 table5 생성
# 두 개의 레코드 삽입
# 실패하는 레코드 삽입 시도
CREATE TABLE table5
(
    id   VARCHAR(8),
    name VARCHAR(20)
);
INSERT INTO table5 (id, name)
values ('id123456', 'namenamenamenamename');
INSERT INTO table5 (id, name)
values ('아이디아이디아이', '이름이름이름이름이름이름이름이름이름이름');
# Error
INSERT INTO table5 (id, name)
values ('id1234567', 'namenamenamenamename');
INSERT INTO table5 (id, name)
values ('아이디아이디아이디', '이름이름이름이름이름이름이름이름이름이름');
INSERT INTO table5 (id, name)
values ('아이디아이디❤️❤️', '이름이름이름이름이름이름이름이름이름이름'); # 이모지(=2글자)
SELECT * FROM table5;


# NUMBER
#   INTEGER, INT (소숫점이 없는)
#   DECIMAL (소숫점이 있는)
CREATE TABLE table6
(
    col1 INT,
    col2 BIGINT # BIGINT 크기: 2^63-1
);
INSERT INTO table6(col1, col2)
VALUES (2342432, 234234234);
INSERT INTO table6(col1, col2)
VALUES (2147483647, 2147483648);
INSERT INTO table6(col1, col2)
VALUES (2147483648, 2147483647);    # Error

# score(정수), length(큰정수) 컬럼 있는 table7 생성
# 두 개의 레코드 삽입
# 한 개의 레코드 삽입 실패
CREATE TABLE table7
(
    score  INT,
    length BIGINT
);
INSERT INTO table7(score, length)
VALUES (234234, 234234);
INSERT INTO table7(score, length)
VALUES (2147483647, 234234);
INSERT INTO table7(score, length)
VALUES (2147483648, 234234);
SELECT * FROM table7;

# DECIMAL, DEC(총길이(정수+소수), 소숫점이하길이)
CREATE TABLE table8
(
    col1 INT,
    col2 DECIMAL(5, 1),
    col3 DECIMAL(10, 3),
    col4 DEC(5, 1),
    col5 DEC(10, 3)
);

INSERT INTO table8 (col1, col2, col3, col4, col5)
VALUES (2342, 1234.5, 1234567.123, NULL, NULL);
INSERT INTO table8 (col1, col2, col3, col4, col5)
VALUES (2342, 1234.56, 1234567.1234, NULL, NULL);   # 소숫점자릿수가 초과되면 반올림 되어 삽입된다.
INSERT INTO table8 (col1, col2, col3, col4, col5)
VALUES (2342, 12345.5, 12345678.123, NULL, NULL);   # Error
SELECT * FROM table8;

# score (총길이4, 소숫점이하2), money(총길이10, 소숫점이하3) table9
CREATE TABLE table9
(
    score DEC(4, 2),
    money DEC(10, 3)
);
INSERT INTO table9(score, money) VALUES (12.34, 1234567.123);
INSERT INTO table9(score, money) VALUES (12.345, 1234567.1234);
INSERT INTO table9(score, money) VALUES (123.45, 12345678.123);
SELECT * FROM table9;

# DATE, TIME
# DATE : 날짜
# TIME : 시간
# DATETIME : 날짜+시간 (1000-01-01 00:00:00 ~ 9999-12-31 23:59:59)
# TIMESTAMP : 날짜+시간 (1970-01-01 00:00:01 ~ 2038-01-19 03:14:07)
CREATE TABLE table10
(
    col1 DATE,
    col2 TIME,
    col3 DATETIME
);
INSERT INTO table10 (col1, col2, col3)
VALUES ('2025-06-11', '10:25:50', '2025-06-11 10:25:50');
INSERT INTO table10 (col1, col2, col3)
VALUES ('2025-06-11', '23:25:50', '2025-06-11 10:25:50');
SELECT * FROM table10;

# birth_date(날짜), work_time(시간), born(날짜시간) table11 생성
# 두 개의 레코드 삽입
CREATE TABLE table11 (birth_date DATE, work_time TIME, born DATETIME);
INSERT INTO table11 VALUES ('1994-07-06', '01:21:38', '1994-07-06 01:21:38');
INSERT INTO table11 VALUES ('1994-07-06', '13:21:38', '1994-07-06 13:21:38');
SELECT * FROM table11;


# STRING : VARCHAR(길이)
# NUMBER : INT, BIGINT, DEC(총길이, 소수점이하길이)
# 날짜시간 : DATE, TIME, DATETIME

CREATE TABLE table12
(
    col1 VARCHAR(10),
    col2 INT,
    col3 BIGINT,
    col4 DEC(10, 2),
    col5 DATE,
    col6 TIME,
    col7 DATETIME
);
SELECT * FROM table12;


CREATE TABLE table13
(
    name       VARCHAR(20),
    birth_date DATE,
    score      DEC(8, 2),
    born_at    DATETIME
);