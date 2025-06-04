# OR
SELECT *
FROM Customers
WHERE City = 'Barcelona'
   OR City = 'Bern'
   OR City = 'Lisboa';  # 4 rows

# IN
SELECT *
FROM Customers
WHERE City IN ('Barcelona', 'Bern', 'Lisboa');  # 4 rows
# 미국, 영국, 스웨덴 고객들 조회
SELECT *
FROM Customers
WHERE Country IN ('USA', 'UK', 'Sweden');   # 22 rows
# 카테고리ID가 1, 2, 5인 상품들 조회
SELECT *
FROM Products
WHERE CategoryID IN (1, 2, 5);  # 31 rows
# 일본, 독일에 있는 공급자(Suppliers) 조회
SELECT *
FROM Suppliers
WHERE Country IN ('Japan', 'Germany');  # 5 rows

# AND
SELECT *
FROM Products
WHERE Price >= 50.00
  AND Price <= 59.99;
# BETWEEN AND
SELECT *
FROM Products
WHERE Price BETWEEN 50.00 AND 59.99;    # 두 조건 값 모두 포함
# 1950년대 출생 직원들 조회
SELECT * FROM Employees WHERE BirthDate BETWEEN '1950-01-01' AND '1959-12-31';  # 4 rows
# 1997년 7월에 주문한 주문 데이터 조회
SELECT * FROM Orders WHERE OrderDate BETWEEN '1997-07-01' AND '1997-07-31'; # 33 rows
