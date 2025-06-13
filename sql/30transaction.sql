# Transaction : 업무 단위
## 세부 업무들은 모두 실패하거나 모두 성공해야한다.
# rollback; //되돌리기
# commit;   //반영하기


# (1) a가 b에게 500원 송금
## (1-1) a의 돈에서 500원 차감
#     UPDATE 계좌_table
#     SET money = money - 500
#     WHERE user = 'a';
## (1-2) b의 돈에서 500원 증가
#     UPDATE 계좌_table
#     SET money = money + 500
#     WHERE user = 'b';
## 두 쿼리를 동시에 실행해야 하나의 업무가 완료된다.

USE mydatabase;
CREATE TABLE table53 (user VARCHAR(10), money INT);
INSERT INTO table53 (user, money) VALUES ('a', 10000), ('b', 10000);
UPDATE table53 SET money = money - 500 WHERE user = 'a';
UPDATE table53 SET money = money + 500 WHERE user = 'b';

SELECT * FROM table53;
# 반영 전에는 다른 세션에서 확인할 때 반영 안되는 것을 확인할 수 있다.

# 현재 트랜잭션을 되돌림
ROLLBACK;
# 현재 트랜잭션 반영(적용)
COMMIT;








