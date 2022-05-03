- ## 문제이름: programmers 없어진기록찾기(Lv3)

  [코딩테스트 연습 - 없어진 기록 찾기 | 프로그래머스 (programmers.co.kr)](https://programmers.co.kr/learn/courses/30/lessons/59042)

  ## 설계

  - Left join과 null인 값을 찾아서 풀어야 하는 문제였다. 
  - 왼쪽 테이블은 무조건 조회되고, 오른쪽 테이블은 조건에 맞는것이 있다면 같이 보여준다.
  ```
  SELECT a.ANIMAL_ID, a.NAME
  FROM ANIMAL_OUTS a LEFT JOIN ANIMAL_INS b
  ON a.ANIMAL_ID = b.ANIMAL_ID
  WHERE b.ANIMAL_ID IS NULL
  ORDER BY a.ANIMAL_ID ASC;
  ```
