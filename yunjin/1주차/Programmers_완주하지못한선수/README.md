- ## 문제이름: programmers 완주하지못한선수(Lv1)

  https://programmers.co.kr/learn/courses/30/lessons/42576

  ## 설계

  - Array.sort를 이용해서 해결
  2) 해시맵을 이용해서 해결
  
  2-1)  *Map.getOrDefault*(key, Default-value) => 찾는 키가 존재한다면 찾는 키의 값을 반환하고 없다면 기본 값을 반환한다.
  
  2-2) 값을 찾을 때는 map.keySet() or Map.Entry 사용
  
  ## 코드
  
  - Map
  
  ```
  import java.util.*;
  
  class Solution {
      public String solution(String[] participant, String[] completion) {
          String answer = "";
          
          //1. 해시맵에 참가자와 번호저장
          HashMap<String,Integer> map = new HashMap<>();
          for(int i=0; i<participant.length; i++){
              map.put(participant[i], map.getOrDefault(participant[i],0)+1);
          }
          
          //2. 해시맵에서 completion에 있는 이름이면 value를 1씩 감소
          for(int i=0; i<completion.length; i++){
               map.put(completion[i], map.get(completion[i])-1);
          }
          
          //3. 해시맵을 돌면서 값이 1이상이면 출력
          for(String key : map.keySet()){
              if(map.get(key)!=0){
                  answer= key;
              }
          }
          
          
          
          return answer;
      }
      
      public static void main(String[] args){
          Solution sol = new Solution();
          String[] participant = {"leo", "kiki", "eden"};
          String[] completion = {"eden", "kiki"};
          
          System.out.println(sol.solution(participant, completion));
      }
  }
  ```
