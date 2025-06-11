USE mydatabase;
# Key : 각 레코드를 구분하는 컬럼(들)
# Primary Key : 대표키, 주요키, 주키, 기본키, PK
#    조건 : (1) UNIQUE, (2) NOT NULL, (3) 값 변경 불가, (4) Insert(삽입) 할 때 결정되어야 함
#    사용 : 대부분의 테이블에 의미없는 id 컬럼 (INT PRIMARY KEY AUTO_INCREMENT)으로 추가한다.
#    복합키 : 여러 개의 컬럼으로 Primary Key를 지정한 키(Key)

# PRIMARY KEY 지정
CREATE TABLE table30
(
    name    VARCHAR(20),
    address VARCHAR(20),
    phone   VARCHAR(20)
);
DROP TABLE table30;
CREATE TABLE table30
(
    name    VARCHAR(20),
    address VARCHAR(20),
#     phone   VARCHAR(20) UNIQUE NOT NULL
    phone   VARCHAR(20) PRIMARY KEY     # PRIMARY KEY = UNIQUE NOT NULL
);
DESC table30;

CREATE TABLE table31
(
    name VARCHAR(20),
    address VARCHAR(20),
    phone VARCHAR(20),
    PRIMARY KEY (phone)
);
DESC table31;

CREATE TABLE table32
(
    name VARCHAR(20),
    address VARCHAR(20),
    notes VARCHAR(20),
    PRIMARY KEY (name,  address)
);
DESC table32;

CREATE TABLE table33
(
    id      INT PRIMARY KEY,                # 의미없는 컬럼을 PRIMARY KEY 지정
    number  VARCHAR(13) NOT NULL UNIQUE,    # 고유값으로 이루어진 컬럼이더라도 값이 변경될 가능성이 조금이라도 있다면 PRIMARY KEY가 되어서는 안된다.
    name    VARCHAR(20),
    address VARCHAR(30)
);
INSERT INTO table33 (id, number, name, address)
VALUES (1, '3-3', 'son', 'seoul')
;
INSERT INTO table33 (id, number, name, address)
VALUES (2, '4-4', 'lee', 'seoul')
;
DROP TABLE table33;

# AUTO_INCREMENT (자동 증가값 삽입)
CREATE TABLE table33
(
    id      INT PRIMARY KEY AUTO_INCREMENT,
    number  VARCHAR(13) NOT NULL UNIQUE,
    name    VARCHAR(20),
    address VARCHAR(30)
);
INSERT INTO table33 (number, name, address)
VALUES ('3-3', 'son', 'seoul')
;
INSERT INTO table33 (number, name, address)
VALUES ('4-4', 'lee', 'seoul')
;
SELECT * FROM table33;