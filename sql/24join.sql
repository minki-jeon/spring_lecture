USE mydatabase;

CREATE TABLE table38
(
    id INT
);
INSERT INTO table38 (id)
VALUES (9),
       (8),
       (7);

SELECT * FROM table34;
SELECT * FROM table35;
SELECT * FROM table38;

# 75(= 5 * 5 * 3) rows, 3(= 1 + 1 + 1) cols
SELECT *
FROM table34 t34
         JOIN table35 t35
         JOIN table38 t38;

SELECT * FROM w3schools.Products JOIN w3schools.Categories JOIN w3schools.Suppliers;
# 77 rows
SELECT * FROM w3schools.Products p JOIN w3schools.Categories c JOIN w3schools.Suppliers s
         WHERE p.CategoryID = c.CategoryID AND p.SupplierID = s.SupplierID;
# 77 rows
SELECT *
FROM w3schools.Products p
         JOIN w3schools.Categories c ON p.CategoryID = c.CategoryID
         JOIN w3schools.Suppliers s ON p.SupplierID = s.SupplierID;
# 카테고리별 공급자 정보
SELECT c.CategoryName, s.SupplierName
FROM w3schools.Products p
         JOIN w3schools.Categories c ON p.CategoryID = c.CategoryID
         JOIN w3schools.Suppliers s ON p.SupplierID = s.SupplierID
ORDER BY c.CategoryName;
#
SELECT DISTINCT s.ShipperName, c.CustomerName
FROM w3schools.Orders o
         JOIN w3schools.Customers c on o.CustomerID = c.CustomerID
         JOIN w3schools.Shippers s ON o.ShipperID = s.ShipperID
ORDER BY s.ShipperName, c.CustomerName;
# 1996-07-05에 주문된 상품명 목록
SELECT o.OrderDate, p.ProductName
FROM w3schools.OrderDetails od
         JOIN w3schools.Orders o ON od.OrderID = o.OrderID
         JOIN w3schools.Products p ON od.ProductID = p.ProductID
WHERE OrderDate = '1996-07-05'
ORDER BY p.ProductName;
# Tofu 상품을 어떤 고객이 언제 주문했는지 조회
# SELECT p.ProductName, c.CustomerName, o.OrderDate
SELECT p.ProductName, c.CustomerName, o.OrderDate
FROM w3schools.Products p
         JOIN w3schools.OrderDetails od on p.ProductID = od.ProductID
         JOIN w3schools.Orders o on od.OrderID = o.OrderID
         JOIN w3schools.Customers c on o.CustomerID = c.CustomerID
#WHERE ProductName = 'Tofu'
WHERE p.ProductID = 14      # 조건에 사용되는 컬럼들은 PK를 사용하면 성능이 향상됨 (Indexing에 의해)
ORDER BY c.CustomerName, o.OrderDate;

# 고객별 주문 금액을 조회 (우수 고객 선정을 위한) # SUM(상품구매수량 * 상품주문가격)
SELECT c.CustomerName, SUM(od.Quantity * p.Price) 합
FROM w3schools.Orders o
         JOIN w3schools.OrderDetails od ON o.OrderID = od.OrderID
         JOIN w3schools.Products p ON od.ProductID = p.ProductID
         JOIN w3schools.Customers c ON o.CustomerID = c.CustomerID
GROUP BY c.CustomerID
ORDER BY 합 DESC;

# 1997년 09월에 가장 많은 주문(가격 기준)을 처리한 직원 조회 (우수 직원 선정을 위한) # SUM(상품1개가격 * 상품주문수량)
SELECT e.FirstName, e.LastName, SUM(p.Price * od.Quantity) 합
FROM w3schools.Employees e
         JOIN w3schools.Orders o on e.EmployeeID = o.EmployeeID
         JOIN w3schools.OrderDetails od on o.OrderID = od.OrderID
         JOIN w3schools.Products p on od.ProductID = p.ProductID
WHERE o.OrderDate BETWEEN '1997-09-01' AND '1997-09-30'
GROUP BY e.EmployeeID
ORDER BY 합 DESC
;
select * from w3schools.OrderDetails;













