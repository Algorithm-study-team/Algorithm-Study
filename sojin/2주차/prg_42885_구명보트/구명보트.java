package ���α׷��ӽ�;

import java.util.*;
class Solution {
    
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        int[]arr=new int[people.length];
        arr=people;
        //�������� ����
        Arrays.sort(arr);

        int j=0;
        
        for(int i=arr.length-1;i>=j;i--){
            //���� �����Ŷ� ���ߴµ��� �Ѵ´�? answer++
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