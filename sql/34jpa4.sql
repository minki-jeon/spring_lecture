USE jpa;

## 다대다(N:N) 관계 테이블
# 고객 테이블
CREATE TABLE my_table31
(
    id      INT AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(30),
    country VARCHAR(30)
);
# 주문 테이블
CREATE TABLE my_table32
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    order_date  DATE,
    info        VARCHAR(30),
    customer_id INT NOT NULL,
    employee_id INT NOT NULL,
    FOREIGN KEY (customer_id) REFERENCES my_table31 (id),
    FOREIGN KEY (employee_id) REFERENCES my_table33 (id)
);
# 직원 테이블
CREATE TABLE my_table33
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(30),
    last_time  VARCHAR(30),
    birth_date DATE,
    info       VARCHAR(50)
);

#학생
CREATE TABLE my_table34
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(30),
    birth_date DATE,
    info       VARCHAR(30)
);
#강의
CREATE TABLE my_table35
(
    id            INT AUTO_INCREMENT PRIMARY KEY,
    lecture_title VARCHAR(30),
    info          VARCHAR(50),
    place         VARCHAR(50)
);
#수강(학생-강의)
CREATE TABLE my_table36
(
    id            INT AUTO_INCREMENT primary key,
    registered_at DATE,
    enabled       VARCHAR(1),
    money         VARCHAR(1),
    student_id    INT NOT NULL,
    lecture_id    INT NOT NULL,
    FOREIGN KEY (student_id) REFERENCES my_table34 (id),
    FOREIGN KEY (lecture_id) REFERENCES my_table35 (id)
);


