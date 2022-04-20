9663: N_Queen
https://www.acmicpc.net/problem/9663

설계
1. 시간복잡도: O(N^M)
2. 풀이: 백트래킹
3. 모든 경우의 수를 탐색하며 체스판 위에 이미 놓았었던 퀸의 자리와 현재 놓을 위치가
퀸의 조건인 열과 대각선이 닿지 않는 경우에만 말을 놓을 수 있도록 하였다.


코드
```java
import java.util.*;

public class BJ_NQUEEN_9663_G5 {
    static int N,cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        dfs(0,new ArrayList<>());
        System.out.println(cnt);
    }

    private static void dfs(int idx, List<Integer> list){
        if(idx == N){
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if(check(i,list)){
                list.add(i);
                dfs(idx+1,list);
                list.remove(list.size()-1);
            }
        }
    }

    private static boolean check(int c, List<Integer> list){
        int r = list.size();

        for (int i = 0; i < r; i++) {
            if(list.get(i) == c || Math.abs(c - list.get(i)) == r-i){
                return false;
            }
        }

        return true;
    }
}
```
