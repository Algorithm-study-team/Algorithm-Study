import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        //1. 해시맵 만들기
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<phone_book.length; i++){
            map.put(phone_book[i], map.getOrDefault(phone_book[i],0)+1);
        }
        
        //2. 해시맵 돌면서 접두어가 있는지 판단
        for(int i=0; i<phone_book.length; i++){
            for(int j=1; j<phone_book[i].length(); j++){
                if(map.containsKey(phone_book[i].substring(0,j))){
                    return false;
                }
            }
        }
        
    
        return answer;
    }
    
    public static void main(String[] args){
        Solution s= new Solution();
        
        String[] phone_book = {"119", "97674223", "1195524421"};
        
        System.out.println(phone_book);
    }
    
}