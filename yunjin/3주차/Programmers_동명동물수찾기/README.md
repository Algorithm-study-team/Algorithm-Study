- ## 문제이름: programmers 동명동물수찾기(Lv2)

  [코딩테스트 연습 - 동명 동물 수 찾기 | 프로그래머스 (programmers.co.kr)](https://programmers.co.kr/learn/courses/30/lessons/59041)

  ## 설계

  - group by 후 having으로 조건처리해주기
  ```
  SELECT NAME, COUNT(*) AS COUNT 
  FROM ANIMAL_INS 
  GROUP BY NAME 
  HAVING COUNT(NAME) >= 2 
  ORDER BY NAME
  ```
