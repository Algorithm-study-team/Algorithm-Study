- ## 문제이름: programmers 프린터(Lv2)

  https://programmers.co.kr/learn/courses/30/lessons/42587

  ## 설계

  - list for문 돌며 max값 구해서 푼것 : 시간초과 -> 다른방법 찾기
  2. for문 이나 while루프보다 stream()함수를 사용하면 편리하다.
  3. location위치를 따로 관리하려면 복잡하기 때문에 class를 사용해서 해결하면 좋다.

  ## 코드

  - Map

  ```
  import java.util.*;
  
  class Solution {
      public static int solution(int[] priorities, int location) {
         
          //1. list이용해서 큐 만들기
          List<Printer> printer = new ArrayList<Printer>();
          for(int i=0; i<priorities.length; i++){
              printer.add(new Printer(priorities[i],i));
          }
          
          int answer = 0;
          
  
          //2. 맨 앞에 있는것 꺼내서 비교하기
          while(!printer.isEmpty()){
              
              Printer p = printer.remove(0);
                  
              if (printer.stream().anyMatch(otherJob -> p.priority < otherJob.priority)) { 
                     printer.add(p); 
              }else{
                      answer++;
                      
                      if(location == p.index){
                          return answer;
                      }
               }
              
              
          }
          return answer;
      }
      
      public static class Printer{
          int priority;
          int index;
          
          public Printer(int priority, int index){
              this.priority = priority;
              this.index = index;
          }
      }
      
      
      public static void main(String[] args){
          
          int[] priorities = {2,1,3,2};
          int location = 0;
          
          System.out.println(solution(priorities,location));
      }
      
      
      
      
  }
  ```
