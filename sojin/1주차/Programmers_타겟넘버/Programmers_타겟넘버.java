package 프로그래머스;

/*
 * 프로그래머스- 타겟 넘버 (Lv-2)
 * https://programmers.co.kr/learn/courses/30/lessons/43165? 
 * BFS 풀이라고 생각한 이유 : DFS로도 풀 수 있을 것 같지만, BFS로 푼 이유는 +와 -의 연산이 있는데, 그것을 Queue에 넣어주고 
 * Queue가 비어있지 않을 때 까지 찾아가며 연산을 해야겠다고 생각했다. 
 */


import java.util.*;

class Solution {
    // BFS풀이 
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
                //빼주기
                queue.offer(new Point(p.idx+1,p.sum-numbers[p.idx+1]));
            }
        }
        return answer;
    }
    
    //DFS 풀이
//    class Solution {
//        static int answer=0;
//        public int solution(int[] numbers, int target) {
//            //numbers배열과 target 합, 인덱스 
//            dfs(numbers,target,+numbers[0],0);
//            dfs(numbers,target,-numbers[0],0);
//            return answer;
//        }
//        public void dfs(int[]numbers,int target,int sum,int idx){
//            //idx 끝까지 도달했다면
//            if(idx==numbers.length-1){
//                if(sum==target){
//                    answer++;
//                }
//            }else{
//                dfs(numbers,target,sum+numbers[idx+1],idx+1);
//                dfs(numbers,target,sum-numbers[idx+1],idx+1); 
//            }
//        }
//    }

    
}