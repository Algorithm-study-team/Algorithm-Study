<h2>2468: 안전영역</h2>

https://www.acmicpc.net/problem/2468

<h2>설계</h2>
시간복잡도: O(N^2)

풀이: DFS

N*N 배열 안에 0~배열안의 가장 큰 수 까지

각각의 수 이하의 위치를 0으로 처리하여 비에 잠긴 지역으로 지정한다.

DFS을 돌며 비에 잠긴 지역이 아닌 1이상인 안전한 위치를 탐색한다.

1이상이 모여있는 영역을 방문배열로 체크한 후 영역의 개수를 추가 시킨다.

<h2>코드</h2>

```java
package algo;

import java.io.*;
import java.util.*;

public class BJ_안전영역_S1_2468 {
	static int N,max,cnt,result;
	static int[][] array,temp;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		array = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, array[i][j]);
			}
		}
		
		for (int i = 0; i <= max; i++) {
			visited = new boolean[N][N];
			temp = new int[N][N];
			
			for (int j = 0; j < N; j++) {
				System.arraycopy(array[j], 0, temp[j], 0, N);
			}
			
			check(i);
			
			cnt = 0;
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					if(!visited[j][k] && temp[j][k] != 0) {
						visited[j][k] = true;
						dfs(j,k);
						cnt++;
					}
				}
			}
			
			result = Math.max(result, cnt);
		}
		
		System.out.println(result);		
	}
	
	private static void check(int k) {
		for (int i = 0; i < temp.length; i++) {
			for (int j = 0; j < temp[i].length; j++) {
				if(temp[i][j] <= k) {
					temp[i][j] = 0;
				}
			}
		}
	}
	
	private static void dfs(int x, int y) {
		for (int i = 0; i < 4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			if(0<=nx && nx<N && 0<=ny && ny<N) {
				if(temp[nx][ny] != 0 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					dfs(nx,ny);
				}
			}
		}
	}
}
```