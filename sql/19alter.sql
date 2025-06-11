USE mydatabase;

# Data없을 때 테이블 수정이 필요하면 DROP하고 다시 수정해서 CREATE
CREATE TABLE table22
(
    col1 INT         NOT NULL,
    col2 VARCHAR(10) NOT NULL
);
DESC table22;
DROP TABLE table22;
CREATE TABLE table22
(
    col1 INT         NOT NULL UNIQUE,
    col2 VARCHAR(10) NOT NULL DEFAULT ''
);
INSERT INTO table22 (col1, col2)
VALUES (3, 'son');
INSERT INTO table22 (col1, col2)
VALUES (5, 'lee');
SELECT * FROM table22;

# ALTER TABLE : 테이블 수정
#    컬럼 추가 / 컬럼 TYPE + 제약사항 변경 / 컬럼명 변경

# 컬럼추가 (ADD COLUMN)
ALTER TABLE table22 ADD COLUMN col3 DATETIME NOT NULL DEFAULT NOW();
DESC table22;

ALTER TABLE table22 ADD COLUMN col4 INT;
ALTER TABLE table22 ADD COLUMN col5 INT NOT NULL;
ALTER TABLE table22 ADD COLUMN col6 VARCHAR(10) NOT NULL;
ALTER TABLE table22 ADD COLUMN col7 VARCHAR(10) NOT NULL UNIQUE;    # 컬럼생성불가 (Duplicate)
                                                                    # => 기존 삽입된 2개행 데이터에 기본값('')이 들어가면서 UNIQUE 위반
ALTER TABLE table22 ADD COLUMN col8 INT;
# 컬럼 추가 위치 지정 (AFTER / FIRST)
ALTER TABLE table22 ADD COLUMN col9 INT AFTER col1;
ALTER TABLE table22 ADD COLUMN col10 INT FIRST;

SELECT * FROM table22;

#
ALTER TABLE table22 ADD COLUMN col11 VARCHAR(10) NOT NULL DEFAULT '없음';
ALTER TABLE table22 ADD COLUMN col12 INT NOT NULL DEFAULT 0;
DESC table22;



# 컬럼명 변경 (CHANGE COLUMN)
create TABLE table23
(
    col1 INT,
    col2 VARCHAR(10)
);
ALTER TABLE table23 CHANGE COLUMN col1 col11 INT;
ALTER TABLE table23 CHANGE COLUMN col11 col21 INT NOT NULL;
ALTER TABLE table23 CHANGE COLUMN col21 col31 VARCHAR(10) NOT NULL;
DESC table23;

# 컬럼 제약사항 변경 (MODIFY COLUMN)
ALTER TABLE table23 MODIFY COLUMN col31 INT NOT NULL UNIQUE;

DESC table23;
# table23 col2의 타입 DEC(10, 2) NOT NULL + UNIQUE 으로 변경
ALTER TABLE table23 MODIFY COLUMN col2 DEC(10, 2) NOT NULL UNIQUE;

# 데이터가 존재하는상태에서 제약사항 변경 시, 오류 발생 가능
CREATE TABLE table24
(
    col1 VARCHAR(5),
    col2 BIGINT
);
INSERT INTO table24(col1, col2)
VALUES ('abcde', 4000000000);
INSERT INTO table24(col1, col2)
VALUES ('abcde', 4000000000);
SELECT * FROM table24;
ALTER TABLE table24 MODIFY COLUMN col1 VARCHAR(3);          # 변경 불가 (보다 큰 데이터가 이미 존재)   // 5 < 3
ALTER TABLE table24 MODIFY COLUMN col1 VARCHAR(10);         # 변경 가능     // 5 < 10
ALTER TABLE table24 MODIFY COLUMN col1 VARCHAR(10) UNIQUE;  # 변경 불가 (이미 중복된 데이터가 존재)    // UNIQUE
ALTER TABLE table24 MODIFY COLUMN col2 INT;                 # 변경 불가 (보다 큰 데이터가 이미 존재)   // BIGINT > INT
ALTER TABLE table24 MODIFY COLUMN col2 BIGINT UNIQUE;       # 변경 불가 (이미 중복된 데이터가 존재)    // UNIQUE






