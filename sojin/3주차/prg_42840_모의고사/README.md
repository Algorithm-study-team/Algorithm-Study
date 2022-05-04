<h2>문제이름:Programmers 모의고사(Lv1)  </h2>

https://programmers.co.kr/learn/courses/30/lessons/42840

<h2>설계</h2>

- 구현

  - 사람이 3명밖에 되지 않기 때문에 아주 쉽게 풀 수 있는 문제였다. 
  - 범위가 넘어가는 부분은 i%배열의 길이로 구할 수 있다.


<h2>코드</h2>

- Map

```java
import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] answer;
        
        int[]arr1={1,2,3,4,5};
        int[]arr2={2,1,2,3,2,4,2,5};
        int[]arr3={3,3,1,1,2,2,4,4,5,5};
        
        answer=new int[3];
        
        for(int i=0;i<answers.length;i++){
            
            if(arr1[i%5]==answers[i]){
                answer[0]++;
            }
            
            if(arr2[i%8]==answers[i]){
                answer[1]++;
            }
            
            if(arr3[i%10]==answers[i]){
                answer[2]++;
            }
            
        }
        
        int max=0;
        max=Math.max(answer[0],Math.max(answer[1],answer[2]));
        
        ArrayList<Integer>list=new ArrayList<>();
        
        if(max==answer[0]){
            list.add(1);
        }
        if(max==answer[1]){
            list.add(2);
        }
        if(max==answer[2]){
            list.add(3);
        }
        
        Collections.sort(list);
        
        answer=new int[list.size()];
        
        for(int i=0;i<list.size();i++){
            answer[i]=list.get(i);
        }
        
        return answer;
    }
}

```

