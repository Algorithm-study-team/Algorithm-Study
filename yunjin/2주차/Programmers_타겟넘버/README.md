- ## 문제이름: programmers 타겟넘버(Lv2)

  [[코딩테스트 연습 - 타겟 넘버 | 프로그래머스 (programmers.co.kr)](https://programmers.co.kr/learn/courses/30/lessons/43165)](https://programmers.co.kr/learn/courses/30/lessons/92334)

  ## 설계

  - DFS 재귀함수로 숫자를 더하고 빼는것을 계산
  ## 코드
  
  ```
  import java.util.*;
  
  class Solution {
      
      int[] numbers;
      int target;
      int answer;
      
      void dfs(int index, int sum){
          
          if(index == numbers.length){
              if(sum == target){
                  answer++;}
                  return;
              
          }
          
          
          dfs(index+1, sum+numbers[index]);
          dfs(index+1, sum-numbers[index]);
          
          
      }
      
      
      public int solution(int[] numbers, int target) {
          answer=0;
          this.numbers= numbers;
          this.target = target;
          
          dfs(0,0); //인덱스, 합
          
          return answer;
      }
  }
  ```
