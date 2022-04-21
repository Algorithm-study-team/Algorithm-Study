- ## 문제이름: programmers 위장(Lv2)

  [코딩테스트 연습 - 위장 | 프로그래머스 (programmers.co.kr)](https://programmers.co.kr/learn/courses/30/lessons/42578)

  ## 설계

  - hashmap을 사용해서 옷 종류별로 몇개인지 각각 판단한 후 조합의 개수 구하기
  ## 코드
  
  - Map
  
  ```
  import java.util.*;
  
  class Solution {
      public int solution(String[][] clothes) {
          int answer = 1;
          
          //1. 해시맵에 옷 종류별로 개수가 몇개인지 등록하기
          HashMap<String,Integer> map = new HashMap<>();
          
          for(String[] clothe: clothes){
              String type = clothe[1];
              map.put(type, map.getOrDefault(type, 0)+1);
          }
          
          //2. 입지않는 경우를 고려해 조합을 계산 (각 옷 종류 + 1)
          Iterator<Integer> it = map.values().iterator();
          
          while(it.hasNext()){
              answer *= it.next().intValue() +1;
          }
          
          //3. 모두 없는 경우를 제외해야함으로 -1
          return answer-1;
      }
      
      public static void main(String [] args){
          
          Solution s = new Solution();
          String[][] clothes = {{"yellowhat", "headgear"}, {"bluesunglasses", "eyewear"},{"green_turban", "headgear"}};
          
          System.out.println(s.solution(clothes));
      }
  }
  ```
