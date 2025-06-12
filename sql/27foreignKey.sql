USE mydatabase;

# 상품 정보
# CREATE TABLE table41
# (
#     id            INT NOT NULL AUTO_INCREMENT,
#     name          VARCHAR(30),
#     price         INT,
#     category_name VARCHAR(30),
#     category_info VARCHAR(30),
#     PRIMARY KEY (id)
# );
# INSERT INTO table41 (name, price, category_name, category_info)
# VALUES
#     ('몽쉘', 1000, '파이', '크림이 있는빵'),
#     ('오예스', 2000, '파이', '크림이 있는빵'),
#     ('게토레이', 500, '음료수', '설탕물'),
#     ('커피', 600, '음료수', '설탕물'),
#     ('가나', 500, '초콜릿', '카카오 가공품'),
#     ('크런키', 500, '초콜릿', '카카오 가공품');

### `category_name` -- `category_info` 키가 아닌 두 컬럼이 종속 관계로 3NF 위반 => category를 별도 테이블로 분리

# 카테고리 테이블 (parent)
CREATE TABLE table42
(
    id   INT AUTO_INCREMENT,
    name VARCHAR(30),       # category_name
    info VARCHAR(30),       # category_info
    PRIMARY KEY (id)
);
# 상품 정보 (child)
CREATE TABLE table41
(
    id          INT NOT NULL AUTO_INCREMENT,
    name        VARCHAR(30),
    price       INT,
    category_id INT,                # table42 참조키
    PRIMARY KEY (id),
    FOREIGN KEY (category_id) REFERENCES table42 (id)
);

INSERT INTO table42 (name, info)
VALUES
    ('파이', '크림이 있는 빵'),
    ('음료수', '설탕물'),
    ('초콜릿', '카카오 가공품');
INSERT INTO table41 (name, price, category_id)
VALUES
    ('몽쉘', 1000, 1),
    ('오예스', 2000, 1),
    ('게토레이', 500, 2),
    ('커피', 600, 2),
    ('가나', 500, 3),
    ('크런키', 500, 3);
# 조회
SELECT * FROM table41;
SELECT * FROM table42;
SELECT * FROM table41 t1 JOIN table42 t2 ON t1.category_id = t2.id;

# INSERT 또는 DELETE 등 명령 수행 시, 제약사항에 의해 수행 불가한 경우 발생
#    - 참조 테이블에 존재하지 않는 참조키를 참조하여 INSERT 하는 경우
#    - 참조하고 있는 데이터의 테이블이 존재할 때 참조테이블의 데이터를 DELETE 하는 경우

# INSERT INTO table41 (name, price, category_id) VALUES ('컴퓨터', 10000, 4);      # FK 제약사항에 의해 INSERT 불가 (존재하지않는 category_id=4)
INSERT INTO table41 (name, price) VALUES ('컴퓨터', 10000);
INSERT INTO table42 (name, info) VALUES ('전자제품', '어쩌구 저쩌구');
UPDATE table41 SET category_id = 4 WHERE id = 8;        # '컴퓨터' 데이터 category_id에 값 갱신
# DELETE FROM table42 WHERE id = 4;                 # FK 제약사항에 의해 DELETE 불가 (category_id=4 참조하고있는 테이블이 존재)
DELETE FROM table41 WHERE category_id = 4;          # 먼저 참조하고 있는 테이블의 데이터 DELETE 실행
SELECT * FROM table41 WHERE category_id = 4;
DELETE FROM table42 WHERE id = 4;                   # 다시 DELETE 실행
SELECT * FROM table42 WHERE id = 4;

