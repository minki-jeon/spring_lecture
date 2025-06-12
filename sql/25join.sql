USE mydatabase;

CREATE TABLE table39
(
    col1 INT
);
CREATE TABLE table40
(
    col_a INT
);
INSERT INTO table39 (col1) VALUES (1), (2), (3), (4), (5);  # 5 rows
INSERT INTO table40 (col_a) VALUES (3), (4), (5), (6), (7), (8), (9);   # 7 rows
SELECT * FROM table39 JOIN table40;     # 35 rows


ALTER TABLE table39 ADD COLUMN name VARCHAR(10);
SELECT * FROM table39;
ALTER TABLE table40 ADD COLUMN toy VARCHAR(10);
SELECT * FROM table40;

# inner join     # 장난감이 있는 사람들
SELECT * FROM table39 JOIN table40 ON table39.col1 = table40.col_a;     # 3 rows

# left (outer) join     # 장난감이 있는 사람들 + 장난감이 없는 사람들
SELECT * FROM table39 LEFT JOIN table40 ON table39.col1 = table40.col_a;    # 5 rows
# left (outer) join     # 장난감이 없는 사람들
SELECT * FROM table39 LEFT JOIN table40 ON table39.col1 = table40.col_a WHERE col_a IS NULL;
# right (outer) join    # 주인이 있는 장난감 + 주인이 없는 장난감
SELECT * FROM table39 RIGHT JOIN table40 ON table39.col1 = table40.col_a;    # 7 rows
# right (outer) join    # 주인이 없는 장난감
SELECT * FROM table39 RIGHT JOIN table40 ON table39.col1 = table40.col_a WHERE col1 IS NULL;

# 주문한 적 없는 고객들
SELECT *
FROM w3schools.Customers c
         LEFT JOIN w3schools.Orders o on c.CustomerID = o.CustomerID
WHERE OrderID IS NULL;

DELETE FROM w3schools.Orders WHERE EmployeeID IN (2, 3);
# 주문을 처리한 적 없는 직원들 조회
SELECT e.EmployeeID, e.LastName, e.FirstName
FROM w3schools.Employees e
         LEFT JOIN w3schools.Orders o on e.EmployeeID = o.EmployeeID
WHERE OrderID IS NULL;
SELECT e.EmployeeID, e.LastName, e.FirstName
FROM w3schools.Orders o
         RIGHT JOIN w3schools.Employees e on e.EmployeeID = o.EmployeeID
WHERE OrderID IS NULL;

# UNION (합집합) : 중복 rows 제외한 모든 데이터 조회
SELECT col1 FROM table39;       # 5 rows
SELECT col_a FROM table40;      # 7 rows
SELECT col1 FROM table39 UNION SELECT col_a FROM table40;  # 9 rows

# FULL OUTER JOIN
SELECT * FROM table39 LEFT JOIN table40 ON table39.col1 = col_a;    # 5 row
SELECT * FROM table39 RIGHT JOIN table40 ON table39.col1 = col_a;   # 7 row
SELECT *
FROM table39
         LEFT JOIN table40 ON table39.col1 = col_a
UNION
SELECT *
FROM table39
         RIGHT JOIN table40 ON table39.col1 = col_a;   # 9 rows

# 한번도 주문된 적 없는 상품들 이름 조회
DELETE
FROM w3schools.OrderDetails
WHERE ProductID IN (10, 20, 30, 40);
SELECT p.ProductID, p.ProductName
FROM w3schools.Products p
         LEFT JOIN w3schools.OrderDetails od on p.ProductID = od.ProductID
WHERE od.OrderID IS NULL
ORDER BY p.ProductID;










