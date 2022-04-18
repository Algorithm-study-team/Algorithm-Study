<h2>문제이름:programmers 타겟넘버(Lv2)  </h2>

https://programmers.co.kr/learn/courses/30/lessons/43165

<h2>설계</h2>

- bfs : queue에 넣어서 탐색하기 위해서 사용
- dfs : 재귀로 탐색을 해나가기 위해서 사용

<h2>코드</h2>

- BFS

```
import java.util.*;

class Solution { 
    private static class Point{
        int idx; //지금 내 인덱스 
        int sum; //지금 내 합 
        
        public Point(int idx,int sum){
            this.idx=idx;
            this.sum=sum;
        }
    }
   
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        Queue<Point>queue=new LinkedList<>();
        
        //시작점 : +와 -로 시작된다. 
        queue.offer(new Point(0,numbers[0]));
        queue.offer(new Point(0,-numbers[0]));
        
        while(!queue.isEmpty()){
            Point p=queue.poll();
            
            //끝까지 도달했는데
            if(p.idx==numbers.length-1){
               //합이랑 target이랑 같아지면 answer++해주기 
                if(p.sum==target){
                   answer++;
               } 
            }else{
            	//더해주고
                queue.offer(new Point(p.idx+1,p.sum+numbers[p.idx+1]));
                //배주기
                queue.offer(new Point(p.idx+1,p.sum-numbers[p.idx+1]));
            }
        }
        return answer;
    }
```

- DFS

```java
import java.util.*;

class Solution {
    static int answer=0;
    public int solution(int[] numbers, int target) {
        //numbers배열과 target 합, 인덱스 
        dfs(numbers,target,+numbers[0],0);
        dfs(numbers,target,-numbers[0],0);
        return answer;
    }
    public void dfs(int[]numbers,int target,int sum,int idx){
        //idx 끝까지 도달했다면
        if(idx==numbers.length-1){
            if(sum==target){
                answer++;
            }
        }else{
            dfs(numbers,target,sum+numbers[idx+1],idx+1);
            dfs(numbers,target,sum-numbers[idx+1],idx+1); 
        }
    }
}
```

