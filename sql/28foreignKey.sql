USE w3schools;

# `Products` 우클릭 > [SQL Scripts] > [Generate DDL to Clipboard]
create table w3schools.Products
(
    ProductID   int auto_increment
        primary key,
    ProductName varchar(255)   null,
    SupplierID  int            null,
    CategoryID  int            null,
    Unit        varchar(255)   null,
    Price       decimal(10, 2) null
);
# 참조키 설정
ALTER TABLE Products
    ADD FOREIGN KEY (CategoryID) REFERENCES Categories (CategoryID);


# `Products` 우클릭 > [SQL Scripts] > [Generate DDL to Clipboard]
create table w3schools.Products
(
    ProductID   int auto_increment
        primary key,
    ProductName varchar(255)   null,
    SupplierID  int            null,
    CategoryID  int            null,
    Unit        varchar(255)   null,
    Price       decimal(10, 2) null,
    constraint Products_ibfk_1
        foreign key (CategoryID) references w3schools.Categories (CategoryID)
);

create index CategoryID
    on w3schools.Products (CategoryID);
##
## `Categories` + `Products` 우클릭 > [Diagrams] > [Show Diagram]
# 특정 key가 있는 테이블(isPrimaryKey)과 그 key를 참조하고 있는 테이블(isForeignKey)의 관계는 1:N (일대다) 관계이다.

# -------------------------------------------------------------------------
# Products 테이블 SupplierID가 Suppliers 의 SupplierID를 참조하는 외래키가 되도록 alter table 실행, Diagram 보기

create table w3schools.Products
(
    ProductID   int auto_increment
        primary key,
    ProductName varchar(255)   null,
    SupplierID  int            null,
    CategoryID  int            null,
    Unit        varchar(255)   null,
    Price       decimal(10, 2) null,
    constraint Products_ibfk_1
        foreign key (CategoryID) references w3schools.Categories (CategoryID)
);

create index CategoryID
    on w3schools.Products (CategoryID);
# 참조키 설정
ALTER TABLE w3schools.Products
    ADD FOREIGN KEY (SupplierID) REFERENCES Suppliers (SupplierID);
#
create table w3schools.Products
(
    ProductID   int auto_increment
        primary key,
    ProductName varchar(255)   null,
    SupplierID  int            null,
    CategoryID  int            null,
    Unit        varchar(255)   null,
    Price       decimal(10, 2) null,
    constraint Products_ibfk_1
        foreign key (CategoryID) references w3schools.Categories (CategoryID),
    constraint Products_ibfk_2
        foreign key (SupplierID) references w3schools.Suppliers (SupplierID)
);

create index CategoryID
    on w3schools.Products (CategoryID);

create index SupplierID
    on w3schools.Products (SupplierID);



create table w3schools.Orders
(
    OrderID    int auto_increment
        primary key,
    CustomerID int  null,
    EmployeeID int  null,
    OrderDate  date null,
    ShipperID  int  null,
    constraint Orders_ibfk_1
        foreign key (CustomerID) references w3schools.Customers (CustomerID),
    constraint Orders_ibfk_2
        foreign key (EmployeeID) references w3schools.Employees (EmployeeID),
    constraint Orders_ibfk_3
        foreign key (ShipperID) references w3schools.Shippers (ShipperID)
);

create index CustomerID
    on w3schools.Orders (CustomerID);

create index EmployeeID
    on w3schools.Orders (EmployeeID);

create index ShipperID
    on w3schools.Orders (ShipperID);








SELECT * FROM Orders;
SELECT * FROM OrderDetails;
# OrderDetails
ALTER TABLE OrderDetails ADD FOREIGN KEY (OrderID) REFERENCES Orders (OrderID);
ALTER TABLE OrderDetails ADD FOREIGN KEY (ProductID) REFERENCES Products (ProductID);
# Orders
ALTER TABLE Orders ADD FOREIGN KEY (CustomerID) REFERENCES Customers (CustomerID);
ALTER TABLE Orders ADD FOREIGN KEY (EmployeeID) REFERENCES Employees (EmployeeID);
ALTER TABLE Orders ADD FOREIGN KEY (ShipperID) REFERENCES Shippers (ShipperID);

## `w3schools` 우클릭 > [Diagrams] > [Show Diagram]





