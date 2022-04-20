import java.util.Arrays;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Arrays.sort(phone_book);
        
        for(int i=0; i<phone_book.length-1; i++){
            //내 뒤의 인덱스가 내 문자를 포함하고 있으면 false
            //contains()는 테스트 1개 실패 => startsWith()
            if(phone_book[i+1].startsWith(phone_book[i])){
                return false;
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