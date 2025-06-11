USE mydatabase;
# 제약사항(Constraint) : 컬럼에 입력 가능한 값을 제한

# NOT NULL : null 허용하지 않음
# UNIQUE : 중복 허용 안함
# DEFAULT : 값 안주면 기본값

# NOT NULL
CREATE TABLE table14
(
    col1 INT,
    col2 INT NOT NULL   # Null 금지
);

INSERT INTO table14 (col1, col2) VALUES (5, 1);
INSERT INTO table14 (col1, col2) VALUES (null, 1);
INSERT INTO table14 (col1, col2) VALUES (null, 11);
INSERT INTO table14 (col1, col2) VALUES (11, null);     # cannot be null
INSERT INTO table14 (col1) VALUES (11);     # 불가
SELECT * FROM table14;

# name(varchar not null), address(varchar) create table15
CREATE TABLE table15
(
    name    VARCHAR(200) NOT NULL,
    address VARCHAR(200)
);
INSERT INTO table15 (name, address) VALUES ('Name', 'Addr');
INSERT INTO table15 (name, address) VALUES ('Name2', null);
INSERT INTO table15 (name) VALUES ('Name3');
INSERT INTO table15 (name, address) VALUES (null, 'Addr2'); # cannot be null


# DEFAULT : 값 안주면 기본값
CREATE TABLE table16
(
    col1 VARCHAR(10),
    col2 VARCHAR(10) default 'anonymous'
);
INSERT INTO table16 (col1, col2)
VALUES ('abc', 'def');
INSERT INTO table16 (col2)
VALUES ('def');
INSERT INTO table16 (col1)
VALUES ('abc');

INSERT INTO table16 (col1, col2)
VALUES ('abc', NULL);

SELECT * FROM table16;

CREATE TABLE table17
(
    col1 VARCHAR(10)          DEFAULT 'val1',
    col2 VARCHAR(10) NOT NULL DEFAULT 'val2'
);
INSERT INTO table17(col1, col2) VALUES ('abc', 'def');
INSERT INTO table17(col1, col2) VALUES (null, 'def');
INSERT INTO table17(col1, col2) VALUES ('abc', null);   # cannot be null
INSERT INTO table17(col2) VALUES ( 'zxc');
INSERT INTO table17(col1) VALUES ( 'abc');
SELECT * FROM table17;

# table18
CREATE TABLE table18
(
    name  VARCHAR(20) NOT NULL,
    score INT         NOT NULL DEFAULT 0
);
INSERT INTO table18 (name, score) VALUES ('Name', 1.55);
INSERT INTO table18 (name, score) VALUES (null, 2.33);      # 'name' cannot be null
INSERT INTO table18 (name, score) VALUES ('Name2', null);   # 'score' cannot be null
INSERT INTO table18 (name) VALUES ('Name3');
INSERT INTO table18 (score) VALUES (3.12);                        # 불가, 'name' doesn't hava a default value (=cannot be null)
SELECT * FROM table18;

# UNIQUE : 중복 허용되지 않음 (Null은 연관되지 않음)
CREATE TABLE table19
(
    col1 VARCHAR(10),
    col2 VARCHAR(10) UNIQUE
);
INSERT INTO table19(col1, col2)
VALUES ('abc', 'qwe');
INSERT INTO table19(col1, col2)
VALUES ('abc', 'def');
INSERT INTO table19(col1, col2)
VALUES ('abc', 'zxc');
INSERT INTO table19(col1, col2)
VALUES ('iop', 'qwe');  # 중복발생 (Duplicate)
INSERT INTO table19(col1)
VALUES ('iop');
INSERT INTO table19(col1)
VALUES ('iop');

SELECT * FROM table19;

CREATE TABLE table20
(
    col1 VARCHAR(3),
    col2 VARCHAR(3) UNIQUE NOT NULL
);
INSERT INTO table20(col1, col2)
VALUES ('abc', 'def');
INSERT INTO table20(col1, col2)
VALUES ('abc', 'qwe');
INSERT INTO table20(col2)
VALUES ('asd');
INSERT INTO table20(col1)
VALUES ('asd');         # 'col2' doesn't have a default value = cannot null
INSERT INTO table20(col2)
VALUES ('qwe');         # 'col2' Duplicate

SELECT * FROM table20;

# table21
CREATE TABLE table21
(
    name  VARCHAR(10) NOT NULL UNIQUE,
    score INT NOT NULL DEFAULT 0
);

INSERT INTO table21 (name, score) VALUES ('Name', 1.55);
INSERT INTO table21 (name, score) VALUES (null, 2.33);      # cannot be null
INSERT INTO table21 (name, score) VALUES ('Name2', null);   # cannot be null
INSERT INTO table21 (name) VALUES ('Name3');
INSERT INTO table21 (name) VALUES ('Name3');        # 'name' Duplicate
INSERT INTO table21 (score) VALUES (3.12);          # 'name' doesn't have a default value = cannot be null
SELECT * FROM table21;




# 테이블의 구조 보기
DESCRIBE table21;   # NOT NULL + UNIQUE = PRIMARY KEY
DESCRIBE table19;
DESC table21;

# 테이블 생성 명령문 출력
SHOW CREATE TABLE table19; # Create Table 필드값에 명령문 출력
CREATE TABLE `table19` (
                           `col1` varchar(10) DEFAULT NULL,
                           `col2` varchar(10) DEFAULT NULL,
                           UNIQUE KEY `col2` (`col2`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

# [Database - table 마우스 우클릭] > SQL Scripts > Generate DDL to Clipboard
create table mydatabase.table21
(
    name  varchar(10)   not null,
    score int default 0 not null,
    constraint name
        unique (name)
);
#
DESC w3schools.Products;
SHOW CREATE TABLE w3schools.Products;
CREATE TABLE `Products` (
                            `ProductID` int NOT NULL AUTO_INCREMENT,
                            `ProductName` varchar(255) DEFAULT NULL,
                            `SupplierID` int DEFAULT NULL,
                            `CategoryID` int DEFAULT NULL,
                            `Unit` varchar(255) DEFAULT NULL,
                            `Price` decimal(10,2) DEFAULT NULL,
                            PRIMARY KEY (`ProductID`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


# DDL, 데이터 정의어
# - SQL 명령어: CREATE, ALTER, DROP, ...
# DML, 데이터 조작어
# - SQL 명령어: INSERT, UPDATE, DELETE, SELECT
# - SELECT는 Java(JDBC) 관점에서 DML과 별개로 기술적으로 구분한다. (상태를 변경하지 않으며, 실행 메서드도 다르기때문에)




# Primary Key : 기본키(PK), 키
# Foreign Key : 외래키(FK), 참조키
