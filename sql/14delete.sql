# DELETE : 특정 데이터/행(Recode, row)를 삭제
DELETE
FROM Customers
WHERE CustomerID = 103;

SELECT *
FROM Customers
WHERE CustomerID = 103
ORDER BY CustomerID DESC;

SELECT *
FROM Customers
WHERE Country IS NULL
ORDER BY CustomerID DESC;

DELETE
FROM Customers
WHERE Country IS NULL;

# 명심 : 삭제(DELETE) 전에 동일한 WHERE절로 SELECT 해서 확인하기
DELETE
FROM Customers
WHERE CustomerID = 100;
SELECT *
FROM Customers
WHERE CustomerID = 100;

# WHERE절 없이 삭제하면 모든 데이터(recode)가 삭제된다.
SELECT * FROM Customers;
DELETE FROM Customers;



#
SELECT *
FROM Suppliers
ORDER BY SupplierID DESC;

SELECT * FROM Suppliers WHERE SupplierID = 28;
DELETE
FROM Suppliers
WHERE SupplierID = 28;

DELETE FROM Suppliers;
SELECT * FROM Suppliers;
