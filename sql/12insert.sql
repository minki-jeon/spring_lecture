SELECT COUNT(*) FROM Customers;

# INSERT INTO : 새 데이터(recode, row) 입력
INSERT INTO Customers
(CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country)
VALUES
    ('92', 'Donald', 'Trump', 'new york', 'CA', '1234', 'USA');

INSERT INTO Customers
(CustomerID, CustomerName, ContactName, Address, PostalCode, Country, city)
VALUES
    ('93', 'Elon', 'Musk', 'LA', 'TA', '5678', 'USA');

INSERT INTO Customers
(CustomerID, CustomerName, ContactName, Address, City, PostalCode, Country)
VALUES
    ('94', 'Park', 'Jisung', 'Suwon', 'Suwon', '9090', 'KOREA');

INSERT INTO Customers
(CustomerName, ContactName, Address, City, PostalCode, Country)
VALUES
    ('Son', 'hm', '강남', '강남', '8080', 'Korea');

INSERT INTO Customers
(CustomerName, ContactName, Address, City, PostalCode, Country)
VALUES
    ('Cha', 'Bum', '수원', '서울', '3030', 'Korea');

SELECT * FROM Customers ORDER BY CustomerID DESC;

# Categories
SELECT * FROM Categories ORDER BY CategoryID DESC;
INSERT INTO Categories
(CategoryName, Description)
VALUES ('커피', '커피 등등');
INSERT INTO Categories
(CategoryName, Description)
VALUES ('잼', '딸기잼, 포도잼');

# Products
SELECT * FROM Products ORDER BY ProductID DESC;
INSERT INTO Products
(ProductName, SupplierID, CategoryID, Unit, Price)
VALUES ('라떼', 1, 1, 'ml', 10.00);
INSERT INTO Products
(ProductName, SupplierID, CategoryID, Unit, Price)
VALUES ('선풍기', 2, 3, '개', 10.00);


# null : 값이 존재하지 않는다.
INSERT INTO Customers
(CustomerName) VALUES ('손흥민');
# 의도적으로 null로 넘김
INSERT INTO Customers
(CustomerName, ContactName) VALUES ('트럼프', NULL);
# null과 ''은 다름
INSERT INTO Customers
(CustomerName, ContactName, Address) VALUES ('트럼프', NULL, '');

SELECT * FROM Categories ORDER BY CategoryID DESC;
INSERT INTO Categories
(CategoryName, Description) VALUES ('핸드폰', null);
INSERT INTO Categories
(CategoryName) VALUES ('책');
INSERT INTO Categories
(CategoryName, Description) VALUES ('물티슈', '');




# DELETE : 기존 데이터(recode, row) 삭제


# UPDATE : 기존 데이터 수정


