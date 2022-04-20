import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        //1. 해시맵에 참가자와 번호저장
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<participant.length; i++){
            map.put(participant[i], map.getOrDefault(participant[i],0)+1);
        }
        
        //2. 해시맵에서 completion에 있는 이름이면 value를 1씩 감소
        for(int i=0; i<completion.length; i++){
             map.put(completion[i], map.get(completion[i])-1);
        }
        
        //3. 해시맵을 돌면서 값이 1이상이면 출력
        for(String key : map.keySet()){
            if(map.get(key)!=0){
                answer= key;
            }
        }

        return answer;

    }
    
    public static void main(String[] args){
        Solution sol = new Solution();
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        
        System.out.println(sol.solution(participant, completion));
    }
}