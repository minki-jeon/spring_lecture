USE mydatabase;

# 게시물 = 제목 + 본문 + 작성일시
# 회원 = ID + PW + 자기소개
# table43 : table44 = N:1 관계 테이블
CREATE TABLE table43
(
    id               INT PRIMARY KEY AUTO_INCREMENT,
    title            VARCHAR(255),
    content          VARCHAR(10000),
    create_at        DATETIME,
    table44_username VARCHAR(20),
    FOREIGN KEY (table44_username) REFERENCES table44 (username)
);
CREATE TABLE table44
(
    username VARCHAR(20) PRIMARY KEY,
    password VARCHAR(20),
    notes    VARCHAR(5000)
);



# 1대N, N대1

# 1대1 관계 (잘 보이지 않음) - 담당자/관리자 권한에 따라 일대일 관계의 테이블로 분리한다.
# 직원 정보 (인사팀 관리)
CREATE TABLE table45
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name      VARCHAR(20),
    hire_date DATE,
    school    VARCHAR(20)
#     salary    INT
);
# 직원 연봉 (총무팀 관리)
CREATE TABLE table46
(
    id     INT,
    salary INT,
    FOREIGN KEY (id) REFERENCES table45 (id)
);
## 1대1(일대일) 관계 테이블을 구성하는 예시를 찾아보기 (ex. 주로 활용하는 데이터만 별도 저장하는 테이블)


## N대N(다대다)
# 학생정보
CREATE TABLE table47
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20),
    info VARCHAR(20)
);
# 수강정보
CREATE TABLE table48
(
    id       INT PRIMARY KEY AUTO_INCREMENT,
    name     VARCHAR(20),
    schedule VARCHAR(20),
    info     VARCHAR(20)
);
## N대N 관계 테이블은 반드시 중간테이블(Enrollment)/연결테이블이 존재해야한다. (즉, 1:N 관계 테이블 + N:1 관계 테이블로 구성)
# 학생 수업 (연결, 조인, 중간 테이블)
CREATE TABLE table49
(
    table47_id INT,
    table48_id INT,

    PRIMARY KEY (table47_id, table48_id),   # 부가정보 컬럼을 추가한다면 PK는 별도로 생성하는 것이 좋다.
    FOREIGN KEY (table47_id) REFERENCES table47 (id),
    FOREIGN KEY (table48_id) REFERENCES table48 (id)
);

## `영화 - 배우` 다대다(N:N) 관계 테이블 생성
CREATE TABLE table50
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    title      VARCHAR(50),
    viewtime   VARCHAR(5),
    info       VARCHAR(100),
    screenDate DATE
);
CREATE TABLE table51
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(20),
    gender     CHAR,
    birth_date DATE,
    age        INT,
    info       VARCHAR(50)
);
CREATE TABLE table52
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    table50_id INT,
    table51_id INT,
    money      INT,
    info       VARCHAR(30),
#     PRIMARY KEY (table50_id, table51_id),
    FOREIGN KEY (table50_id) REFERENCES table50 (id),
    FOREIGN KEY (table51_id) REFERENCES table51 (id)
);




