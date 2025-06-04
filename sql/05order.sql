# ORDER BY : 조회 결과 순서(정렬) 결정

# 고객번호 오름차순
SELECT * FROM Customers ORDER BY CustomerID;
# 고객명 오름차순
SELECT * FROM Customers ORDER BY CustomerName;
# 상품 가격 오름차순
SELECT * FROM Products ORDER BY Price;

# ORDER BY [1st], [2nd], ...
SELECT CustomerName, City, Country FROM Customers ORDER BY Country, City;

# 카테고리별, 가격별 오름차순 상품조회
SELECT CategoryID, Price, ProductName FROM Products ORDER BY CategoryID, Price;
# 오름차순 (ASCENDING, ASC)
SELECT CategoryID, Price, ProductName FROM Products ORDER BY CategoryID ASC, Price ASC;
# 내림차순 (DESCENDING, DESC)
SELECT * FROM Products ORDER BY Price DESC;
# 생일 내림차순 정렬 직원 조회
SELECT * FROM Employees ORDER BY BirthDate DESC;
# 카테고리(오름차순), 가격(내림차순) 순서로 상품 조회
SELECT CategoryID, Price, ProductName FROM Products ORDER BY CategoryID, Price DESC;

#
SELECT Country, City, CustomerName
FROM Customers;

SELECT Country, City, CustomerName
FROM Customers
ORDER BY Country, City;
# 컬럼의 순서 사용
SELECT Country, City, CustomerName
FROM Customers
ORDER BY 1, 2;

SELECT ProductName, CategoryID, Price
FROM Products
ORDER BY Price DESC;
SELECT ProductName, CategoryID, Price
FROM Products
ORDER BY 3 DESC;










