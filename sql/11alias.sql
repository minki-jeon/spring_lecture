# ALIAS (AS) : 컬럼이나 테이블에 별칭 부여
SELECT CustomerID, ContactName
FROM Customers;

SELECT CustomerID AS Name, ContactName AS Contact
FROM Customers;

# AS 생략 가능
SELECT CustomerID Name, ContactName Contact
FROM Customers;

#
SELECT AVG(Price)
FROM Products;

SELECT AVG(Price) AS 평균가격
FROM Products;

SELECT AVG(Price) 평균가격
FROM Products;

SELECT AVG(Price) '평균 가격'
FROM Products;

SELECT AVG(Price) `평균 가격`
FROM Products;

# 테이블에 별칭 주기
SELECT p.ProductName, c.CategoryName
FROM Products AS p,
     Categories AS c;

SELECT p.ProductName, c.CategoryName
FROM Products p,
     Categories c;


#############################
# 페이징연습용 쿼리
#############################
# 대량의 고객 정보 입력
INSERT INTO Customers
(customername, contactname, address, city, postalcode, country)
SELECT CustomerName, ContactName, Address, City, PostalCode, Country
FROM Customers;
SELECT COUNT(*) FROM Customers;
# 대량의 상품 정보 입력
INSERT INTO Products
(PRODUCTNAME, SUPPLIERID, CATEGORYID, UNIT, PRICE)
SELECT  PRODUCTNAME, SUPPLIERID, CATEGORYID, UNIT, PRICE
FROM Products;
SELECT COUNT(*) FROM Products;

