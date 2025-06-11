USE mydatabase;

# NORMALIZATION : 정규화(형)

# FIRST NORMAL FORM (1NF) : 1정규화(1정규형)
# SECOND NORMAL FORM (2NF) : 2정규화(2정규형)
# THIRD NORMAL FORM (3NF) : 3정규화(3정규형)

# 1NF 조건: 모든 레코드가 유일해야하고, 모든 데이터는 Atomic(원자적) 해야한다.
#     Atomic(원자성) = 하나의 속성에 하나의 값(데이터)
#           * 컬럼이 아닌 컬럼의 `의미`로 단위 구분한다.
#     모든 레코드 유일함 => PRIMARY KEY(=NOT NULL UNIQUE) 컬럼이 적어도 하나 있어야함.

CREATE TABLE table25
(
    name  VARCHAR(10),
    phone VARCHAR(200)
);
INSERT INTO table25(name, phone)
VALUES ('sno', '01099998888');
INSERT INTO table25(name, phone)
VALUES ('sno', '01099997777,01088886666');  # phone 데이터는 원자적이지 않다. 원자성을 이루지 않는다. (1NF 위배)

SELECT * FROM table25;

CREATE TABLE table26(name VARCHAR(10), phone1 VARCHAR(200), phone2 VARCHAR(200));
INSERT INTO table26(name, phone1) VALUES('son', '01099998888');
# phone(phone1, phone2) 컬럼 분리했더라도 데이터는 원자적이지 않다. (값이 2개 이상) **********************************보충
INSERT INTO table26(name, phone1, phone2) VALUES('son', '01099998888', '01055553333');
SELECT * FROM table26;
ALTER TABLE table26 ADD COLUMN address VARCHAR(10) AFTER name;
UPDATE table26 SET address = 'seoul' WHERE name = 'son';
UPDATE table26 SET address = 'busan' WHERE name = 'kim';
SELECT * FROM table26;

# 원자성(atomic) 제거하기 위해 별도의 테이블 생성
CREATE TABLE table27
(
    name  VARCHAR(10),
    phone VARCHAR(11)
);
INSERT INTO table27 (name, phone)
VALUES
    ('son', '01099998888'),
    ('kim', '01088887777'),
    ('kim', '01055553333');
SELECT * FROM table27;
    # table26, table27 테이블 분리하여 1NF 만족
ALTER TABLE table26 DROP COLUMN phone1;
ALTER TABLE table26 DROP COLUMN phone2;
SELECT * FROM table26;
SELECT * FROM table27;

#
CREATE TABLE table28
(
    name    VARCHAR(10),
    address VARCHAR(10),
    work    VARCHAR(10)
);
INSERT INTO table28 (name, address, work)
VALUES ('kim', 'seoul', 'intel');
INSERT INTO table28 (name, address, work)
VALUES ('lee', 'busan', 'intel');
INSERT INTO table28 (name, address, work)
VALUES ('choi', 'seoul', 'tesla');
INSERT INTO table28 (name, address, work)
VALUES ('kim', 'jeju', 'google');
INSERT INTO table28 (name, address, work)
VALUES ('kim', 'jeju', 'google');   # 모든 레코드가 유일하지 않게됨. 1NF 위배
SELECT * FROM table28;

ALTER TABLE table28 ADD COLUMN id INT UNIQUE ;  # 데이터가 존재하면 불가, 테이블 생성할 때 설정해야함.

CREATE TABLE table29
(
    id      INT NOT NULL UNIQUE,
    name    VARCHAR(20),
    address VARCHAR(20),
    work    VARCHAR(20)
);
DESC table29;

