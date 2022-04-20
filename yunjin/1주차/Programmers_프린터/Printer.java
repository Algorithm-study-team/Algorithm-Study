import java.util.*;

class Solution {
    public static int solution(int[] priorities, int location) {
       
        //1. list로 printer구성
        List<Printer> printer = new ArrayList<Printer>();
        for(int i=0; i<priorities.length; i++){
            printer.add(new Printer(priorities[i],i));
        }
        
        int answer = 0;
        

        //2. 맨 앞에 있는것 꺼내서 비교하기
        while(!printer.isEmpty()){
            
            Printer p = printer.remove(0);
            
	//3.나보다 큰 값이 있다면 맨 뒤에 붙이기
            if (printer.stream().anyMatch(otherJob -> p.priority < otherJob.priority)) { 
                   printer.add(p); 
            }else{
                    answer++;
                    
                    if(location == p.index){
                        return answer;
                    }
             }
            
            
        }
        return answer;
    }
    
    public static class Printer{
        int priority;
        int index;
        
        public Printer(int priority, int index){
            this.priority = priority;
            this.index = index;
        }
    }
    
    
    public static void main(String[] args){
        
        int[] priorities = {2,1,3,2};
        int location = 0;
        
        System.out.println(solution(priorities,location));
    }
    
    
    
    
}