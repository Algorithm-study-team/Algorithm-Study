- ## 문제이름: programmers 신규아이디추천(Lv1)

  [코딩테스트 연습 - 신규 아이디 추천 | 프로그래머스 (programmers.co.kr)](https://programmers.co.kr/learn/courses/30/lessons/72410)

  ## 설계

  - 각 문자열을 변경할 수 있도록 설계한다.
  - 정규표현식을 사용하면 더 쉽게 처리가 가능하다.
  ## 코드
  
  - 
  
  ```
  import java.util.*;
  
  class Solution {
      public String solution(String new_id) {
          String answer = "";
          
          //1단계
          new_id = new_id.toLowerCase();
          
          //2단계
          for(int i=0 ; i<new_id.length(); i++){
              
              char ch = new_id.charAt(i);
              if(Character.isAlphabetic(ch) || Character.isDigit(ch)  ||
                ch == '-' ||ch == '_' ||ch == '.'  ){
                   answer+=ch;
              }  
          }
          
          //3단계
          while(answer.indexOf("..")!=-1){
              answer = answer.replace("..",".");
          }
          //4단계
          if(!answer.isEmpty() && answer.charAt(0)=='.'){
              answer= answer.substring(1);
          }
          if(!answer.isEmpty() && answer.charAt(answer.length()-1)=='.'){
              answer= answer.substring(0, answer.length()-1);
          }
          
          //5단계
          if(answer.isEmpty()){
              answer +="a";
          }
          
          //6단계
          if(answer.length()>15){
              answer = answer.substring(0,15);
              
               if(answer.charAt(answer.length()-1)=='.'){
                   answer= answer.substring(0, answer.length()-1);
               }
          }
          
          //7단계
          while(answer.length() <3){
              answer += answer.charAt(answer.length() -1);
          }
          
          return answer;
      }
      
      public static void main(String[] args){
          Solution s= new Solution();
          
          String new_id ="...!@BaT#*..y.abcdefghijklm";
          
          System.out.println(s.solution(new_id));
      }
  }
  ```
