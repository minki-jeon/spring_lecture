# sql주석
# 실행되지 않는 코드
# 설명용으로 사용
# 단축키 Ctrl + / : 주석

SELECT *
FROM Customers;

# 단축키 Ctrl + Enter : 쿼리(sql) 실행
# 한 명령문(쿼리)는 ;으로 마침

SELECT *
FROM Employees;
# 쿼리는 대소문자 구분하지 않음
select *
from Employees;

# 관습 - 키워드: 대문자, 테이블명+컬럼명: 소문자

# SELECT ~ FROM
SELECT *
FROM Employees;
SELECT *
FROM Categories;
SELECT *
FROM Suppliers;

# 데이터들은 행과 열의 조합으로 저장되어 있다.
# 테이블: 행과 열의 조합으로 데이터를 저장한 곳

# Employees
# 9개의 행, 6개의 열
SELECT *
FROM Employees;

# Categories
# 8개의 행, 3개의 열
SELECT *
FROM Categories;

# Shippers
# 3개의 행, 3개의 열
SELECT * FROM Shippers;

# SELECT : 열을 선택
# FROM : 테이블 지정
# WHERE : 행을 선택(Filter)

SELECT *
FROM Shippers;
SELECT *
FROM Customers;
SELECT *
FROM Employees;

