<h2>문제이름:Programmers 키패드누르기(Lv1)  </h2>

https://programmers.co.kr/learn/courses/30/lessons/67256

<h2>설계</h2>

- 구현

  - 그냥 열심히 따라서 구현하면 풀 수 있는 문제였다.
  - 너무 하드코딩느낌이 나서 아쉬웠다 나중에 리팩토링해서 간단한 코드를 만들어봐야겠다.
  - stringbuilder로 str을 담아주고나서 str.toString()하니까 편했다.


<h2>코드</h2>

- Map

```java
package 코테준비2;
import java.util.*;

class Solution {
    static StringBuilder str=new StringBuilder();
     //-1은 * -2은#이다.
    static int[][]arr={{-1,0,-2},{7,8,9},{4,5,6},{1,2,3}};
    static int[] dis;
    public String solution(int[] numbers, String hand) {
        String answer = "";
        dis=new int[2];

        int left=-1;
        int right=-2;
        Point lefts=new Point(0,0); //초기위치 잡아주기(바로 2,5,8이 나올수도있음)
        Point rights=new Point(0,2);
        
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==1||numbers[i]==4||numbers[i]==7){
                left=numbers[i];
                finds(numbers[i]); //그 숫자의 r,c구하기
                lefts=new Point(dis[0],dis[1]);
                str.append("L");
            }else if(numbers[i]==3||numbers[i]==6||numbers[i]==9){
                right=numbers[i];
                 finds(numbers[i]);
                rights=new Point(dis[0],dis[1]);
                str.append("R");
            }else{
                 finds(numbers[i]);
                 int ldis=(int)Math.abs(lefts.r-dis[0])+(int)Math.abs(lefts.c-dis[1]);
                 int rdis=(int)Math.abs(rights.r-dis[0])+(int)Math.abs(rights.c-dis[1]);
                 if(rdis>ldis){
                     str.append("L");
                     lefts=new Point(dis[0],dis[1]);
                 }else if(rdis<ldis){
                     str.append("R");
                     rights=new Point(dis[0],dis[1]);
                 }else{
                     if(hand.equals("left")){
                         str.append("L");
                          lefts=new Point(dis[0],dis[1]);
                     }else{
                          str.append("R");
                         rights=new Point(dis[0],dis[1]);
                     }
                 }
            }
        }
        answer=str.toString();
        
        return answer;
    }
    //좌표반환
    public static void finds(int number){
        for(int r=0;r<4;r++){
            for(int c=0;c<3;c++){
                if(arr[r][c]==number){
                    dis[0]=r;
                    dis[1]=c;
                }
            }
        }
    }
    
    public static class Point{
        int r,c;
        public Point(int r,int c){
            this.r=r;
            this.c=c;
        }
    }
}

```

