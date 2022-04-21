<h2>문제이름:programmers 메뉴 리뉴얼(Lv2)  </h2>

https://programmers.co.kr/learn/courses/30/lessons/72411

<h2>설계</h2>

- 조합 : 

  - 정해진 orders(문자열)에 따른 course(개수)만큼 음식을 고르는 것이다. -> 순서는 상관이 없으니 조합을 사용했다. ex) orders: ABC , course:2이면, AB,AC,BC을 고를 수 있다. 
  - 다만, 이때 뽑은 문자열을 오름차순으로 정렬을 해야하는데, 그대로 Arrays.sort()을 사용하면 조합이 이상해져서, 미리 문자열로 합친 후 그것을 다시 정렬해서 map에 넣어주었다. 

- Map : 

  - <String,Integer> 을 <음식조합,나온개수> 형태로 관리한다면 더 편할 것이라고 생각하여 Map을 사용했다.

  - 조합 개수가 최대인 것을 여러개 출력해야하니까, max값을 구하고 그 값을 value로 가지고 있는 key을 출력하도록 했다. 

    

<h2>코드</h2>

- Map

```java
package 프로그래머스;

import java.util.*;

class Solution {
    static Map<String,Integer>map;
    public String[] solution(String[] orders, int[] course) {
        
         List<String>list=new ArrayList<>();
            //개수만큼 먼저 뽑아주기 
            for(int i=0;i<course.length;i++){
                map=new HashMap<>();
                for(int j=0;j<orders.length;j++){
                    // 몇개 뽑을건지, 어떤 문자열에서, 0부터 시작할거임 , 몇개 저장?
                      combination(course[i],orders[j],0,new char[course[i]]);
                }
                //map에 course개수만큼 뽑힌게 들어있다.
                int max=1;
                for(Map.Entry<String,Integer>elem : map.entrySet()){
                    //최대 value값 구하기 
                    if(max<elem.getValue()){
                        max=elem.getValue();
                    }
                 }
                
                //그 최댓값이 1이 아니라면?
                if(max!=1){
                     for(Map.Entry<String,Integer>elem : map.entrySet()){
                      //value가 max와 같다면 key값 넣어주기
                     if(elem.getValue()==max){
                       list.add(elem.getKey());
                     }
                 }
                }
            }
         String[] answer = new String[list.size()];
        //list 오름차순 정렬
        Collections.sort(list);
        for(int k=0;k<list.size();k++){
            answer[k]=list.get(k);
        }
        return answer;
    }
    
     public static void combination(int toChoosed,String str,int toStart,char[]ans){
	        if(toChoosed==0){
                //문자열로 합치기 -> 정렬 후 합치면 이상해짐 : 합치고 정렬해야함
	            String temp2 = new String(ans);
               
                //이제 그 문자열을 다시 정렬 
	            char[] charArr = temp2.toCharArray();
                Arrays.sort(charArr);
                String temp=new String(charArr);
                
                if(map.containsKey(temp)){
	                //있으면 +1 해주기
	                map.put(temp,map.get(temp)+1);
                    System.out.println("update"+temp);
                     return;
	            }else{
	                map.put(temp,1);
                    System.out.println("put"+temp);
	                return;
                }
	           
	        }
	        for(int i=toStart;i<str.length();i++){
	        	ans[ans.length-toChoosed]=str.charAt(i);
	        	combination(toChoosed - 1, str, i + 1,ans);
	        }
	    }
}

```

