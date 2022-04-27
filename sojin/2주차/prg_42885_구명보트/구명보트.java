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