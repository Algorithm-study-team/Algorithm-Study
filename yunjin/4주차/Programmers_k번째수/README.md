- ## 문제이름: programmers k번째수(Lv1)

  [코딩테스트 연습 - K번째수 | 프로그래머스 (programmers.co.kr)](https://programmers.co.kr/learn/courses/30/lessons/42748?language=java)

  ## 설계

  - 배열 처리 후 정렬
  ```
  import java.util.Arrays;
  
  class Solution {
     public int[] solution(int[] array, int[][] commands) {
          int[] answer = new int[commands.length];
  
          for (int i = 0; i < commands.length; i++) {
              int[] tempArray = new int[commands[i][1] - commands[i][0] + 1];
  
              int a = 0;
              for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                  tempArray[a] = array[j];
                  a++;
              }
              Arrays.sort(tempArray);
              answer[i] = tempArray[commands[i][2] - 1];
          }
          return answer;
      }
  }
  ```
