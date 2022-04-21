- ## 문제이름: programmers 전화번호목록(Lv2)

  [코딩테스트 연습 - 전화번호 목록 | 프로그래머스 (programmers.co.kr)](https://programmers.co.kr/learn/courses/30/lessons/42577)

  ## 설계

  - Array.sort를 이용해서 해결

  2) 해시맵을 이용해서 해결

  2-1) 접두어가 있는지 판단 : map.containsKey(phone_book[i].substring(0,j));

  ## 코드

  - Map

  ```
  import java.util.*;
  
  class Solution {
      public boolean solution(String[] phone_book) {
          boolean answer = true;
          
          //1. 해시맵 만들기
          HashMap<String, Integer> map = new HashMap<>();
          
          for(int i=0; i<phone_book.length; i++){
              map.put(phone_book[i], map.getOrDefault(phone_book[i],0)+1);
          }
          
          //2. 해시맵 돌면서 접두어가 있는지 판단
          for(int i=0; i<phone_book.length; i++){
              for(int j=1; j<phone_book[i].length(); j++){
                  if(map.containsKey(phone_book[i].substring(0,j))){
                      return false;
                  }
              }
          }
          
      
          return answer;
      }
      
      public static void main(String[] args){
          Solution s= new Solution();
          
          String[] phone_book = {"119", "97674223", "1195524421"};
          
          System.out.println(phone_book);
      }
      
  }
  ```
