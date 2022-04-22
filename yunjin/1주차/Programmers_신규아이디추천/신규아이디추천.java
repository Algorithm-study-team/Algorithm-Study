import java.util.*;

class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        //1단계
        new_id = new_id.toLowerCase();
        
        //2단계
        for(int i=0 ; i<new_id.length(); i++){
            
            char ch = new_id.charAt(i);
            if(Character.isAlphabetic(ch) || Character.isDigit(ch)  ||
              ch == '-' ||ch == '_' ||ch == '.'  ){
                 answer+=ch;
            }  
        }
        
        //3단계
        while(answer.indexOf("..")!=-1){
            answer = answer.replace("..",".");
        }
        //4단계
        if(!answer.isEmpty() && answer.charAt(0)=='.'){
            answer= answer.substring(1);
        }
        if(!answer.isEmpty() && answer.charAt(answer.length()-1)=='.'){
            answer= answer.substring(0, answer.length()-1);
        }
        
        //5단계
        if(answer.isEmpty()){
            answer +="a";
        }
        
        //6단계
        if(answer.length()>15){
            answer = answer.substring(0,15);
            
             if(answer.charAt(answer.length()-1)=='.'){
                 answer= answer.substring(0, answer.length()-1);
             }
        }
        
        //7단계
        while(answer.length() <3){
            answer += answer.charAt(answer.length() -1);
        }
        
        return answer;
    }
    
    public static void main(String[] args){
        Solution s= new Solution();
        
        String new_id ="...!@BaT#*..y.abcdefghijklm";
        
        System.out.println(s.solution(new_id));
    }
}