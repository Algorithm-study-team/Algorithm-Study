import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
//1. 정렬
        Arrays.sort(participant);
        Arrays.sort(completion);
        
//2. 앞부터 비교하면서 다른게 있으면 답
        for(int i=0; i<completion.length; i++){
            if(!participant[i].equals(completion[i])){
                return participant[i];
            }
        }
        
        answer = participant[participant.length-1];
        return answer;
    }
    
    public static void main(String[] args){
        Solution sol = new Solution();
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        
        System.out.println(sol.solution(participant, completion));
    }
}