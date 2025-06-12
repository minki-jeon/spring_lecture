USE mydatabase;

CREATE TABLE table34
(
    name VARCHAR(1)
);

CREATE TABLE table35
(
    score INT
);

INSERT INTO table34 (name)
VALUES ('a'),
       ('b'),
       ('c'),
       ('d'),
       ('e');
INSERT INTO table35 (score)
VALUES (5),
       (4),
       (3),
       (3),
       (5);
SELECT * FROM table34;
SELECT * FROM table35;

# 25 rows, 2 cols
SELECT *
FROM table34,
     table35;

## Cartesian Product (카테시안 곱)
# 616(= 77 * 8) rows, 9(= 6 + 3) cols
SELECT *
FROM w3schools.Products,
     w3schools.Categories;
# 616(= 77 * 8) rows, 9(= 6 + 3) cols
SELECT *
FROM w3schools.Products
         JOIN w3schools.Categories;

CREATE TABLE table36
(
    `대회`  VARCHAR(20),
    `연도`  INT,
    `우승자` VARCHAR(30),
    PRIMARY KEY (`대회`, `연도`)
);
CREATE TABLE table37
(
    `우승자` VARCHAR(30),
    `생년월일`  VARCHAR(100),
    PRIMARY KEY (`우승자`)
);
INSERT INTO table36 (대회, 연도, 우승자)
VALUES ('D', '1998', 'chip'),
       ('I', '1998', 'al'),
       ('C', '1999', 'bob'),
       ('D', '1999', 'al'),
       ('I', '1999', 'chip');
INSERT INTO table37 (우승자, 생년월일)
VALUES ('chip', '97-3-14'),
       ('al', '75-7-21'),
       ('bob', '68-9-28');
# 15 rows (카테시안 곱)
SELECT *
FROM table36
         JOIN table37;

# JOIN 테이블
SELECT *
FROM table36
         JOIN table37
WHERE table36.우승자 = table37.우승자;
SELECT *
FROM table36
         JOIN table37
              ON table36.우승자 = table37.우승자;

# Column '우승자' in field list is ambiguous
SELECT `대회`, `연도`, `우승자`, `생년월일`
FROM table36
         JOIN table37 ON table36.우승자 = table37.우승자;
#
SELECT `대회`, `연도`, table36.`우승자`, `생년월일`
FROM table36
         JOIN table37 ON table36.우승자 = table37.우승자;
SELECT `대회`, `연도`, table37.`우승자`, `생년월일`
FROM table36
         JOIN table37 ON table36.우승자 = table37.우승자;
# ALIAS (AS) : 별칭 (AS 생략 가능)
SELECT `대회` AS congress, `연도` year, t7.`우승자`, `생년월일`
FROM table36 AS t6
         JOIN table37 t7 ON t6.우승자 = t7.우승자;

#
SELECT *
FROM w3schools.Products;
SELECT *
FROM w3schools.Categories;
SELECT p.ProductName, c.CategoryName
FROM w3schools.Products p
         JOIN w3schools.Categories c on p.CategoryID = c.CategoryID
ORDER BY c.CategoryName, p.ProductName;

# 공급자별 공급하는 상품 목록 조회
SELECT * FROM w3schools.Suppliers;
SELECT * FROM w3schools.Products;
SELECT s.SupplierName, p.ProductName
FROM w3schools.Products p
         JOIN w3schools.Suppliers s ON s.SupplierID = p.SupplierID
ORDER BY s.SupplierName, p.ProductName;

# 주문별 처리 직원 (+직원 Janet의 주문 조건 조회)
SELECT o.OrderDate, o.OrderID, e.FirstName, e.LastName
FROM w3schools.Orders o
         JOIN w3schools.Employees e ON o.EmployeeID = e.EmployeeID
WHERE e.EmployeeID = 3;

# 1번 고객이 주문한 날짜들 조회
SELECT c.CustomerName, o.OrderDate
FROM w3schools.Customers c
         JOIN w3schools.Orders o on c.CustomerID = o.CustomerID
WHERE c.CustomerID = 1
ORDER BY o.OrderDate;

# 고객별 주문 건수
SELECT c.CustomerID, c.CustomerName, COUNT(*)
FROM w3schools.Orders o
         JOIN w3schools.Customers c on o.CustomerID = c.CustomerID
GROUP BY c.CustomerID
HAVING COUNT(*) > 20
ORDER BY c.CustomerID;

# 카테고리별 상품의 평균가격
SELECT c.CategoryID, c.CategoryName, AVG(p.Price)
FROM w3schools.Categories c
         JOIN w3schools.Products p on c.CategoryID = p.CategoryID
GROUP BY c.CategoryID
ORDER BY c.CategoryID;

# 직원별 주문 처리 건수 (+ 1997년도 주문건 조건 조회)
SELECT e.EmployeeID, e.LastName, e.FirstName, COUNT(*)
FROM w3schools.Employees e
         JOIN w3schools.Orders o on e.EmployeeID = o.EmployeeID
WHERE OrderDate BETWEEN '1997-01-01' AND '1997-12-31'
GROUP BY e.EmployeeID
ORDER BY e.EmployeeID;




















