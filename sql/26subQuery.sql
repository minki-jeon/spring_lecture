USE mydatabase;
# sub query : 쿼리 안에 쿼리

# 한번도 주문된 적 없는 상품들 이름 조회
DELETE
FROM w3schools.OrderDetails
WHERE ProductID IN (10, 20, 30, 40);
SELECT p.ProductID, p.ProductName
FROM w3schools.Products p
         LEFT JOIN w3schools.OrderDetails od on p.ProductID = od.ProductID
WHERE od.OrderID IS NULL
ORDER BY p.ProductID;

# 1. 주문된 적 있는 상품 ID 조회
SELECT ProductID
FROM w3schools.OrderDetails;
# 2. 위 쿼리 결과에 존재하지 않는 상품ID들 조회
SELECT *
FROM w3schools.Products
WHERE ProductID NOT IN (SELECT ProductID FROM w3schools.OrderDetails);

# 상품과 카테고리 정보 조회 (JOIN / SubQuery)
SELECT Products.ProductID, ProductName, CategoryName
FROM w3schools.Products
         JOIN w3schools.Categories c ON Products.CategoryID = c.CategoryID;
SELECT ProductID,
       ProductName,
       (SELECT CategoryName FROM w3schools.Categories c WHERE c.CategoryID = p.CategoryID)
FROM w3schools.Products p;



# 1996-08-01에 주문 처리한 직원명 조회 (JOIN / SubQuery)
SELECT e.EmployeeID, e.FirstName, e.LastName
FROM w3schools.Employees e JOIN w3schools.Orders o on e.EmployeeID = o.EmployeeID
WHERE o.OrderDate = '1996-08-01';
SELECT e.EmployeeID, e.FirstName, e.LastName
FROM w3schools.Employees e
WHERE e.EmployeeID IN (SELECT EmployeeID FROM w3schools.Orders WHERE OrderDate = '1996-08-01');
#
SELECT o.OrderDate, e.FirstName, e.LastName FROM w3schools.Orders o JOIN w3schools.Employees e on o.EmployeeID = e.EmployeeID WHERE OrderDate = '1996-08-01';
SELECT OrderDate, (SELECT e.FirstName FROM w3schools.Employees e WHERE e.EmployeeID = o.EmployeeID) FROM w3schools.Orders o WHERE OrderDate = '1996-08-01';

# 상품 전체의 평균가격보다 높은 상품들 조회 (SubQuery)
SELECT AVG(Price) FROM w3schools.Products;  #상품 전체의 평균가격 조회
SELECT * FROM w3schools.Products
         WHERE Price > (SELECT AVG(Price) FROM w3schools.Products);

# 상품의 평균 가격이 50이상인 카테고리 번호
SELECT CategoryID, AVG(Price) FROM w3schools.Products GROUP BY CategoryID
                                                      HAVING AVG(Price) >= 50;
# SubQuery
SELECT *
FROM
    (SELECT CategoryID, AVG(Price) avg FROM w3schools.Products GROUP BY CategoryID) p
WHERE avg >= 50;

#### 1996-09 월 평균 처리 금액보다 높은 금액을 처리한 직원 목록 (TODO)

# (1) 1996-09 월 평균 처리 금액
# SELECT OrderID, EmployeeID, OrderDate FROM w3schools.Orders WHERE OrderDate BETWEEN '1996-09-01' AND '1996-09-30';
# SELECT OrderDetailID, OrderID, ProductID, Quantity FROM w3schools.OrderDetails;
# SELECT ProductID, Price FROM w3schools.Products;
# SELECT AVG(p.Price * od.Quantity) avg
# FROM w3schools.Orders o
#          JOIN w3schools.OrderDetails od ON o.OrderID = od.OrderID
#          JOIN w3schools.Products p on od.ProductID = p.ProductID
# WHERE o.OrderDate BETWEEN '1996-09-01' AND '1996-09-30';
# (2) 직원별 1996-09 월 평균 처리금액
# SELECT e.EmployeeID, e.FirstName, e.LastName
# , (SELECT AVG(p.Price * od.Quantity) avg
# FROM w3schools.Orders o
#          JOIN w3schools.OrderDetails od ON o.OrderID = od.OrderID
#          JOIN w3schools.Products p on od.ProductID = p.ProductID
# WHERE o.OrderDate BETWEEN '1996-09-01' AND '1996-09-30') o
# FROM w3schools.Employees e
# GROUP BY e.EmployeeID;

## (TODO) 1996-09 월 평균 처리 금액보다 높은 금액을 처리한 직원 목록
# 1. 총 처리 금액
# 2. 처리한 직원의 수
# 3. 1.결과를 2.로 나눈다
# 4. 직원별 처리 금액
# 5. 평균금액보다 높은 직원 조회
# (1)
SELECT SUM(od.Quantity * p.Price)
FROM w3schools.Orders o
         JOIN w3schools.OrderDetails od ON o.OrderID = od.OrderID
         JOIN w3schools.Products p on od.ProductID = p.ProductID
WHERE o.OrderDate BETWEEN '1996-09-01' AND '1996-09-30';
# (2)
SELECT COUNT(DISTINCT EmployeeID)
FROM w3schools.Orders o
WHERE o.OrderDate BETWEEN '1996-09-01' AND '1996-09-30';
# (3)
SELECT (SELECT SUM(od.Quantity * p.Price)
        FROM w3schools.Orders o
                 JOIN w3schools.OrderDetails od ON o.OrderID = od.OrderID
                 JOIN w3schools.Products p on od.ProductID = p.ProductID
        WHERE o.OrderDate BETWEEN '1996-09-01' AND '1996-09-30')
           / (SELECT COUNT(DISTINCT EmployeeID)
              FROM w3schools.Orders o
              WHERE o.OrderDate BETWEEN '1996-09-01' AND '1996-09-30');

# TODO
#
# SELECT e.EmployeeID, e.LastName, e.FirstName, SUM(od.Quantity * p.Price) sum
# FROM w3schools.Orders o
#          JOIN w3schools.OrderDetails od
#               ON o.OrderID = od.OrderID
#          JOIN w3schools.Products p
#               ON od.ProductID = p.ProductID
#          JOIN w3schools.Employees e ON
#     e.EmployeeID = o.EmployeeID
# WHERE o.OrderDate BETWEEN '1996-09-01' AND '1996-09-30'
# GROUP BY e.EmployeeID
# HAVING sum > (SELECT (SELECT SUM(od.Quantity * p.Price)
#                       FROM w3schools.Orders o
#                                JOIN w3schools.OrderDetails od
#                                     ON o.OrderID = od.OrderID
#                                JOIN w3schools.Products p
#                                     ON od.ProductID = p.ProductID
#                       WHERE o.OrderDate BETWEEN '1996-09-01' AND '1996-09-30') /
#                      (SELECT COUNT(DISTINCT EmployeeID)
#                       FROM w3schools.Orders o
#                       WHERE o.OrderDate BETWEEN '1996-09-01' AND '1996-09-30'))
# ORDER BY EmployeeID;


