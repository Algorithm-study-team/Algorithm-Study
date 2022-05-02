- ## 문제이름: programmers 숫자 문자열과 영단어(Lv1)

  [코딩테스트 연습 - 숫자 문자열과 영단어 | 프로그래머스 (programmers.co.kr)](https://programmers.co.kr/learn/courses/30/lessons/81301)

  ## 설계

  - 문자열 관련한 replaceAll 함수를 사용하면 간단한 문제
  ## 코드
  
  ```
  class Solution {
      public int solution(String s) {
      String[] convert = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
      
      for (int i = 0; i < convert.length; i++) {
          s = s.replaceAll(convert[i], Integer.toString(i));
      }
      
      return Integer.parseInt(s);
      }
  }
  ```
