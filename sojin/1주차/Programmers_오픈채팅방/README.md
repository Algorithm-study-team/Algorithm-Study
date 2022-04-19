<h2>문제이름:programmers 오픈채팅방(Lv2)  </h2>

https://programmers.co.kr/learn/courses/30/lessons/42888

<h2>설계</h2>

- Map : id와 닉네임을 key, value 형태로 관리한다면 더 효율적이라고 생각 
- 닉네임이 다 변경된 후 출력해줘야함
- 출력값이 String[]이기 때문에 list을 만들어서 저장 후 다시 String[]으로 옮겨 담아줌

<h2>코드</h2>

- Map

```java
package 프로그래머스;

import java.util.*;

class Solution {
  
    public String[] solution(String[] record){
        //아이디와 닉네임을 key-value형태로 저장할거다
        Map<String,String>map=new HashMap<String,String>();
        List<String>list=new ArrayList<>();
        StringTokenizer tokens;
        
        //끝까지 변경 
        for(int j=0;j<record.length;j++){
            
            tokens=new StringTokenizer(record[j]);
            String[]some=new String[3];
            int k=0;
            while(tokens.hasMoreTokens()){
                some[k++]=tokens.nextToken(); //some[0] -> 동작 some[1] -> 아이디 			some[2] -> 
            }
            //Enter나 Change을 만나면 변경해주기
            if(some[0].equals("Enter")||some[0].equals("Change")){
              map.put(some[1],some[2]);  
            }
        }
        
        // 다 변경 후 출력
          for(int j=0;j<record.length;j++){
            
            tokens=new StringTokenizer(record[j]);
            String[]some=new String[3];
            int k=0;
            while(tokens.hasMoreTokens()){
                some[k++]=tokens.nextToken(); //some[0] -> 동작 some[1] -> 아이디 		some[2] -> 
            }
           
            if(some[0].equals("Enter")){
                list.add(map.get(some[1])+"님이 들어왔습니다.");
            }else if(some[0].equals("Leave")){
                list.add(map.get(some[1])+"님이 나갔습니다.");
            }
        
        }
        String[] answer = new String[list.size()];
        for(int z=0;z<answer.length;z++){
            answer[z]=list.get(z);
        }
        return answer;
    }
}
```

