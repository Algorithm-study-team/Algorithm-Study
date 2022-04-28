- ## 문제이름: programmers 체육복(Lv1)

  [코딩테스트 연습 - 체육복 | 프로그래머스 (programmers.co.kr)](https://programmers.co.kr/learn/courses/30/lessons/42862?language=java)

  ## 설계

  - greedy 알고리즘 문제로 처음에 sorting을 해주어야한다.
  ## 코드
  
  ```
  import java.util.Arrays;
  
  class Solution {
      public int solution(int n, int[] lost, int[] reserve) {
          int count = 0;
          Arrays.sort(lost);
          Arrays.sort(reserve);
          for(int i=0; i < lost.length; i++) {
              for(int j=0; j < reserve.length; j++) {
                  if(lost[i] == reserve[j]) {
                      lost[i] = -1;
                      reserve[j] = -1;
                      count++;
                      break;
                  }
              }
          }
          for (int i=0; i < lost.length; i++) {
              for (int j=0; j < reserve.length; j++) {
                  if(lost[i] == reserve[j]+1 || lost[i] == reserve[j]-1) {
                      count++;
                      reserve[j] = -1;
                      break;
  
                  }
              }
          }
          return n - lost.length + count;
  
      }
  }
  ```
