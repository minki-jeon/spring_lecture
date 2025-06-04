# WHERE : 행을 선택 (filter)
SELECT *
FROM Employees;

# 1개 행
SELECT *
FROM Employees
WHERE EmployeeID = 3;
# 3개 행
SELECT *
FROM Employees
WHERE EmployeeID < 4;
# 4개 행
SELECT *
FROM Employees
WHERE BirthDate BETWEEN '1950-01-01' AND '1959-12-31';
# 5개 행
SELECT *
FROM Employees
WHERE Notes LIKE '%BA%';

# 연산자
# = 같다
SELECT *
FROM Customers
WHERE Country = 'UK';
# 미국인 고객들 조회
SELECT *
FROM Customers
WHERE Country = 'USA';
# 특정 도시에 있는 고객들 조회
SELECT *
FROM Customers
WHERE City = 'London';

# 비교연산자
# !=, <> : 같지 않다.
SELECT *
FROM Customers
WHERE City != 'london';
# 미국인이 아닌 고객들 조회
SELECT *
FROM Customers
WHERE Country <> 'USA'; # 78 rows
# 스웨덴인이 아닌 고객들 조회
SELECT *
FROM Customers
WHERE Country != 'Sweden'; # 89 rows
# >, >=, <, <=
SELECT *
FROM Customers
WHERE CustomerID < '5';     # 수형식(숫자)은 따옴표 생략가능
SELECT *
FROM Customers
WHERE CustomerID <= '5';
SELECT *
FROM Customers
WHERE CustomerID > 88;
SELECT *
FROM Customers
WHERE CustomerID > 88;
SELECT *
FROM Customers
WHERE CustomerName >= 'T';
SELECT *
FROM Customers
WHERE CustomerName >= 't';
SELECT *
FROM Customers
WHERE CustomerName < 'D';
SELECT *
FROM Customers
WHERE CustomerName < 'd';

# Products(상품) 테이블 조회 - Price(가격) 50미만, 80이상 상품 데이터 조회
SELECT *
FROM Products
WHERE Price < 50;   # 70 rows
SELECT *
FROM Products
WHERE Price >= 80;  # 4 rows
# Orders(주문) 테이블 조회 - OrderDate(주문날짜)가 1998년 1월 1일 이후(포함)인 데이터 조회, 1996년 12월 31일 이전(포함)인 데이터 조회
SELECT *
FROM Orders
WHERE OrderDate >= '1998-01-01';    # 270 rows
SELECT *
FROM Orders
WHERE OrderDate <= '1996-12-31';    # 152 rows

# 논리연산자
# AND, OR, NOT

#NOT
SELECT *
FROM Customers
WHERE NOT (City = 'Berlin');    # 90row
SELECT *
FROM Customers
WHERE NOT City = 'Berlin';
# 미국에 살지 않는 고객들 조회
SELECT *
FROM Customers
WHERE Country = 'USA';      #
SELECT *
FROM Customers
WHERE NOT (Country = 'USA');    # 78 rows

# OR
SELECT *
FROM Customers
WHERE CustomerID = 1
   OR CustomerID = 2;
SELECT *
FROM Customers
WHERE Country = 'USA'
   OR Country = 'UK';

# CategoryID가 1 또는 7인 상품들 조회
SELECT * FROM Products WHERE CategoryID = 1 OR CategoryID = 7;      # 17 rows
# 도시 Madrid 또는 Lisboa에 있는 고객들 조회
SELECT * FROM Customers WHERE City = 'Madrid' OR City = 'Lisboa';   # 5 rows
SELECT * FROM Customers WHERE City = 'Madrid' OR City = 'Lisboa' OR City = 'Barcelona';   # 6 rows

# AND
SELECT * FROM Customers WHERE CustomerID >= 10 AND CustomerID < 20;     # 10 rows
# 1950-01-01 ~ 1959-12-31 태어난 직원들 조회
SELECT * FROM Employees WHERE BirthDate >= '1950-01-01' AND BirthDate <= '1959-12-31';  # 4 rows
# 가격 50.00(포함) ~ 60.00(포함안함) 상품들 조회
SELECT * FROM Products WHERE Price >= 50 AND Price < 60;    # 2 rows
# 'B'로 시작하는 이름인 고객들 조회
SELECT * FROM Customers WHERE CustomerName >= 'B' AND CustomerName < 'C';       # 7 rows
SELECT * FROM Customers WHERE CustomerName LIKE 'B%';       # 7 rows
SELECT * FROM Customers WHERE CustomerName >= 'B' AND CustomerName < 'C' AND Country = 'France';       # 2 rows









