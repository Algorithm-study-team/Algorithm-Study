package ���α׷��ӽ�;

/*
 * ���α׷��ӽ�- Ÿ�� �ѹ� (Lv-2)
 * https://programmers.co.kr/learn/courses/30/lessons/43165? 
 * BFS Ǯ�̶�� ������ ���� : DFS�ε� Ǯ �� ���� �� ������, BFS�� Ǭ ������ +�� -�� ������ �ִµ�, �װ��� Queue�� �־��ְ� 
 * Queue�� ������� ���� �� ���� ã�ư��� ������ �ؾ߰ڴٰ� �����ߴ�. 
 */


import java.util.*;

class Solution {
    // BFSǮ�� 
    private static class Point{
        int idx; //���� �� �ε��� 
        int sum; //���� �� �� 
        
        public Point(int idx,int sum){
            this.idx=idx;
            this.sum=sum;
        }
    }
   
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        Queue<Point>queue=new LinkedList<>();
        
        //������ : +�� -�� ���۵ȴ�. 
        queue.offer(new Point(0,numbers[0]));
        queue.offer(new Point(0,-numbers[0]));
        
        while(!queue.isEmpty()){
            Point p=queue.poll();
            
            //������ �����ߴµ�
            if(p.idx==numbers.length-1){
               //���̶� target�̶� �������� answer++���ֱ� 
                if(p.sum==target){
                   answer++;
               } 
            }else{
            	//�����ְ�
                queue.offer(new Point(p.idx+1,p.sum+numbers[p.idx+1]));
                //���ֱ�
                queue.offer(new Point(p.idx+1,p.sum-numbers[p.idx+1]));
            }
        }
        return answer;
    }
    
    //DFS Ǯ��
//    class Solution {
//        static int answer=0;
//        public int solution(int[] numbers, int target) {
//            //numbers�迭�� target ��, �ε��� 
//            dfs(numbers,target,+numbers[0],0);
//            dfs(numbers,target,-numbers[0],0);
//            return answer;
//        }
//        public void dfs(int[]numbers,int target,int sum,int idx){
//            //idx ������ �����ߴٸ�
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