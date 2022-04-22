<h2>문제이름:programmers 카카오프렌즈 컬러링북(Lv2)  </h2>

https://programmers.co.kr/learn/courses/30/lessons/1829

<h2>설계</h2>

- DFS : 
  - 한 점을 기준으로 끝까지 내려가 탐색을 하기 때문에 dfs을 사용했다.  백준에서 단지번호 붙이기랑 비슷한 기본적인 dfs 문제였다. 
  - picture 배열이 int로 선언이 되어있는데, 범위를 벗어날 수도 있다고 생각하여 long으로 옮겨 담았다.
  - 처음에 영역과 최대 넓이를 구하는 전역변수를 static 부분에서 초기화를 했는데 계속 정답 fail 떠서 solution 함수 내에서 초기화를 했더니 pass가 떴다. 이 함수를 여러번 실행할 수도 있어서 그런가??

<h2>코드</h2>

- DFS

```java
package 프로그래머스;

class Solution {
    
    static int[][]deltas={{-1,0},{1,0},{0,-1},{0,1}};
    static boolean[][]visited;
    static long[][]pictures;
    static int maxSizeOfOneArea;
    static int numberOfArea; // 영역
    static int area;
    static int m1,n1;
    public int[] solution(int m, int n, int[][] picture) {
        pictures=new long[m][n];
        visited=new boolean[m][n];
        //전역변수에 복사해주기
        m1=m;
        n1=n;
        
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                pictures[r][c]=(long)picture[r][c];
            }
        }
        maxSizeOfOneArea=Integer.MIN_VALUE;
        numberOfArea=0;
        //dfs돌리기
        for(int r=0;r<m;r++){
            for(int c=0;c<n;c++){
                //방문하지 않았고, 그 지점이 0(공백)이 아니라면
                if(!visited[r][c]&&pictures[r][c]!=0){
                    //몇번인지 저장을 하고 
                    long cnt=pictures[r][c];
                    area=1; //영역 넓이 
                    visited[r][c]=true; //방문 체크 후
                    //dfs에 넘겨준다.
                    dfs(r,c,cnt);
                    numberOfArea++; //일을 다 끝나고 돌아오면 영역++
                    //최댓값을 구해준다.
                    if(maxSizeOfOneArea<area){
                        maxSizeOfOneArea=area;
                    }
                } 
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    
     private static void dfs(int r,int c,long cnt){
        
        for(int d=0;d<deltas.length;d++){
            int nr=r+deltas[d][0];
            int nc=c+deltas[d][1];
            //내부에 있고, cnt와 같고, 방문하지 않았다면?
            if(isIn(nr,nc)&&pictures[nr][nc]==cnt&&!visited[nr][nc]){
                visited[nr][nc]=true;
                area++;
                dfs(nr,nc,cnt);
            }
        }
    }
    
    private static boolean isIn(int r,int c){
        return r>=0&&c>=0&&r<m1&&c<n1;
    }
    
}
```

