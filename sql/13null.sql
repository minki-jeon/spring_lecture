SELECT * FROM Customers ORDER BY CustomerID DESC;

# 집계 함수는 NULL을 집계에 포함하지 않음

# 99
SELECT COUNT(CustomerName)
FROM Customers;

# 99
SELECT COUNT(CustomerID)
FROM Customers;

# 96 (NULL 제외)
SELECT COUNT(ContactName)
FROM Customers;
# 97 (NULL 제외)
SELECT COUNT(Address)
FROM Customers;

# 2242.71
SELECT SUM(Price)
FROM Products;
INSERT INTO Products(ProductName)
VALUES ('커피');
# 28.388734
SELECT AVG(Price)
FROM Products;
INSERT INTO Products(ProductName)
VALUES ('컴퓨터');
# 28.388734
SELECT AVG(Price)
FROM Products;

# NULL인 컬럼 조회
SELECT *
FROM Customers
WHERE ContactName = 'bum'
ORDER BY CustomerID DESC;
SELECT *
FROM Customers
# WHERE ContactName = NULL
WHERE ContactName IS NULL
ORDER BY CustomerID DESC;
SELECT *
FROM Customers
# WHERE ContactName != NULL
WHERE ContactName IS NOT NULL
ORDER BY CustomerID DESC;

#
SELECT Description FROM Categories ORDER BY CategoryID DESC;
SELECT Description
FROM Categories
WHERE Description IS NULL
ORDER BY CategoryID DESC;
SELECT Description
FROM Categories
WHERE Description IS NOT NULL
ORDER BY CategoryID DESC;

SELECT * FROM Products ORDER BY ProductID DESC;
SELECT SUM(Price) FROM Products;    # 2242.71
SELECT AVG(Price) FROM Products;    # 28.388734
# IFNULL(컬럼, 값) : NULL 인 경우 다른 값으로 반환(출력)
SELECT ProductID, ProductName, SupplierID, IFNULL(CategoryID, '미정') CategoryID, IFNULL(Unit, '없다') Unit, IFNULL(Price, 0) Price
FROM Products
ORDER BY ProductID DESC;
SELECT SUM(IFNULL(Price, 0)) FROM Products;    # 2242.71
SELECT AVG(IFNULL(Price, 0)) FROM Products;    # 27.687778
#
SELECT * FROM Categories ORDER BY CategoryID DESC;
SELECT CategoryID, CategoryName, IFNULL(Description, '정해지지 않음') Description
FROM Categories
ORDER BY CategoryID DESC;
SELECT COUNT(Description) FROM Categories;
SELECT COUNT(IFNULL(Description, '')) FROM Categories;




