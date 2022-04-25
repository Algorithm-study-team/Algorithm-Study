- ## 문제이름: programmers 신고결과받기(Lv1)

  [코딩테스트 연습 - 신고 결과 받기 | 프로그래머스 (programmers.co.kr)](https://programmers.co.kr/learn/courses/30/lessons/92334)

  ## 설계

  - 초반에 HashSet을 이용해서 중복을 제거해준다.
  - HashMap으로 사용자들 목록을 정리해준다.
  ## 코드
  
  - 
  
  ```
  import java.util.*;
  class Solution {
      public int[] solution(String[] id_list, String[] report, int k) {
          int[] answer = new int[id_list.length];
          
          //1. hashset만들기
          HashSet<String> reportSet = new HashSet<String>();
          for(String r: report){
              reportSet.add(r);
          }
          
          //2. [신고당한사람, <신고한사람들>]의 hashmap만들기
          HashMap<String, ArrayList<String>> notifyListHash = new HashMap<>();
          
          for(String r : reportSet){
              int blankIndex = r.indexOf(" ");
              String reportee = r.substring(blankIndex+1);
              String reporter = r.substring(0, blankIndex);
              
              ArrayList<String> reporterList = notifyListHash.getOrDefault(reportee, null);
              if(reporterList == null){
                  reporterList = new ArrayList<>();
              }
              
              reporterList.add(reporter);
              notifyListHash.put(reportee,reporterList);
              
          }
          
          //3. 신고한사용자 : 횟수를 HashMap으로 만들기
          HashMap<String, Integer> reporterHash = new HashMap<>();
          for(ArrayList<String> notifyList : notifyListHash.values()){
              if(notifyList.size() >=k){
                  for(String reporter : notifyList){
                      reporterHash.put(reporter, reporterHash.getOrDefault(reporter,0)+1);
                  }
              }
          }
          
          //4. answer 배열 채우기
          for(int i=0; i< id_list.length; i++){
              answer[i] = reporterHash.getOrDefault(id_list[i],0);
          }
          
          
          return answer;
      }
  }
  ```
