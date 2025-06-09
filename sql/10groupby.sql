#GROUP BY : 특정 컬럼값 기준으로 결과를 나눔

SELECT CategoryID, SUM(Price)
FROM Products
GROUP BY CategoryID
ORDER BY CategoryID;

# 카테고리별 상품가격의 평균
SELECT CategoryID, AVG(Price)
FROM Products
GROUP BY CategoryID
ORDER BY CategoryID;

# 카테고리별 최고상품 가격
SELECT CategoryID, MAX(Price)
FROM Products
GROUP BY CategoryID
ORDER BY CategoryID;

# 카테고리별 최저상품 가격
SELECT CategoryID, MIN(Price)
FROM Products
GROUP BY CategoryID
ORDER BY CategoryID;

# 카테고리별 상품의 수량
SELECT CategoryID, COUNT(*)
FROM Products
GROUP BY CategoryID
ORDER BY CategoryID;


# 국가별 고객의 수
SELECT Country, COUNT(*)
FROM Customers
GROUP BY Country
ORDER BY Country;