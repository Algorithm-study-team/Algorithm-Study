- ## 문제이름: programmers 고양이와개는몇마리있을까(Lv2)

  

  [코딩테스트 연습 - 고양이와 개는 몇 마리 있을까 | 프로그래머스 (programmers.co.kr)](https://programmers.co.kr/learn/courses/30/lessons/59040)

  
  
  ## 설계
  
  - 프로그래머스 SQL 문제 중 select문제들과 group by문제들을 풀었고, 그 중 group by 풀이문제를 올리겠습니다.
  ## 코드
  
  ```
  SELECT ANIMAL_TYPE, COUNT(ANIMAL_TYPE) 
  FROM ANIMAL_INS
  GROUP BY ANIMAL_TYPE
  ORDER BY ANIMAL_TYPE
  ```
