<h2>문제이름:프로그래머스 구명보트(Lv2)  </h2>

https://programmers.co.kr/learn/courses/30/lessons/42885

<h2>설계</h2>

- 그리기
  - 제한이 있고, "최대한 적은 보트를 사용해야한다"라는 조건이 그리디 같았다.
  - 오름차순 정렬 후 제일 작은 것과 제일 큰 것을 더해서 비교하고자 했다.
  - 50 60 70 90 이고 limit이 130이면, 90 기준에선 제일 작은 50과 더했는데 limit(130)을 넘어버리면 그 이후 어떤 수를 더하더라도 130이 넘으니까 혼자 타야한다.
  - 이러한 로직으로 무게를 넘으면 혼자 타니까 보트 수++, 넘지 않으면 그 보트를 같이 탄거니까 비교 수++,보트 수++을 해주었다.

<h2>코드</h2>

```java
package 프로그래머스;

import java.util.*;
class Solution {
    
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        int[]arr=new int[people.length];
        arr=people;
        //오름차순 정렬
        Arrays.sort(arr);

        int j=0;
        
        for(int i=arr.length-1;i>=j;i--){
            //제일 작은거랑 더했는데도 넘는다? answer++
            if(arr[i]+arr[j]>limit){
                answer++;
            }else if(arr[i]+arr[j]<=limit){
                answer++;
                j++;
            }
        }
  
        return answer;
    
}
}
```

