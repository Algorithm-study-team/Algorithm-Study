package ���α׷��ӽ�;

import java.util.*;

class Solution {
  
    public String[] solution(String[] record){
        //���̵�� �г����� key-value���·� �����ҰŴ�
        Map<String,String>map=new HashMap<String,String>();
        List<String>list=new ArrayList<>();
        StringTokenizer tokens;
        
        //������ ���� 
        for(int j=0;j<record.length;j++){
            
            tokens=new StringTokenizer(record[j]);
            String[]some=new String[3];
            int k=0;
            while(tokens.hasMoreTokens()){
                some[k++]=tokens.nextToken(); //some[0] -> ���� some[1] -> ���̵� some[2] -> 
            }
            //Enter�� Change�� ������ �����Y�� 
            if(some[0].equals("Enter")||some[0].equals("Change")){
              map.put(some[1],some[2]);  
            }
        }
        
        // �� ���� �� ���
          for(int j=0;j<record.length;j++){
            
            tokens=new StringTokenizer(record[j]);
            String[]some=new String[3];
            int k=0;
            while(tokens.hasMoreTokens()){
                some[k++]=tokens.nextToken(); //some[0] -> ���� some[1] -> ���̵� some[2] -> 
            }
           
            if(some[0].equals("Enter")){
                list.add(map.get(some[1])+"���� ���Խ��ϴ�.");
            }else if(some[0].equals("Leave")){
                list.add(map.get(some[1])+"���� �������ϴ�.");
            }
        
        }
        String[] answer = new String[list.size()];
        for(int z=0;z<answer.length;z++){
            answer[z]=list.get(z);
        }
        return answer;
    }
}