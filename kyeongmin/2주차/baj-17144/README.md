<h2>17144: 미세먼지 안녕!</h2>

https://www.acmicpc.net/problem/17144

<h2>설계</h2>

풀이: 시뮬레이션

1. 미세먼지를 동시에 처리하기 위해서 미세먼지가 있는 좌표를 전역 Queue에 넣는다.
2. Queue를 돌며 범위에 벗어나지 않으며 공기청정기가 아닌 구역에는 미세먼지를 퍼트린다.
3. 공기청정기를 작동 - 배열을 돌릴때는 정방향으로 돌리지 않고 반대 방향에서 부터 돌린다.

<h2>코드</h2>

```java
package algo;

import java.io.*;
import java.util.*;

public class BJ_미세먼지안녕_17144_G4 {	
	static int R,C,T,result;
	static int[][] array;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static Queue<Point> q;
	static List<Point> list;
	
	public static class Point {
		int x,y,d;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public Point(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		array = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				if(array[i][j] == -1) {
					list.add(new Point(i,j));
				}
			}
		}
		
		for (int i = 0; i < T; i++) {
			check();
			mise();
			air();
		}
		
		go();
		System.out.println(result);
	}
	
	private static void air() {
		for (int k = 0; k < list.size(); k+=2) {
			int x = list.get(k).x;
			int y = list.get(k).y;
			
			for (int i = x-1 ; i > 0; i--) {
				array[i][0] = array[i-1][0];
			}
			
			for (int i = 0; i < C-1; i++) {
				array[0][i] = array[0][i+1];
			}
			
			for (int i = 0; i < x; i++) {
				array[i][C-1] = array[i+1][C-1];
			}
			
			for (int i = C-1; i > 1; i--) {
				array[x][i] = array[x][i-1]; 
			}
			
			array[x][1] = 0;
		
		}
		
		for (int k = 1; k < list.size(); k+=2) {
			int x = list.get(k).x;
			int y = list.get(k).y;
			
			for (int i = x+1; i < R-1; i++) {
				array[i][0] = array[i+1][0];
			}
			
			for (int i = 0; i < C-1; i++) {
				array[R-1][i] = array[R-1][i+1];
			}
			
			for (int i = R-1; i > x; i--) {
				array[i][C-1] = array[i-1][C-1];
			}
			
			for (int i = C-1; i > 1; i--) {
				array[x][i] = array[x][i-1];
			}
			
			array[x][1] = 0;
			
		}
		
	}
	
	private static void go() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(1 <= array[i][j]) {
					result += array[i][j];
				}
			}
		}
	}
	
	private static void check() {
		q = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(1 <= array[i][j]) {
					q.add(new Point(i,j,array[i][j]));
				}
			}
		}
	}
	
	private static void mise() {
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if(p.d < 5) continue;
			
			int cnt = 0;
			
			int d = p.d/5;
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(0<=nx && nx<R && 0<=ny && ny<C) {
					if(array[nx][ny] != -1) {
						cnt++;
						array[nx][ny] += d;
					}
				}
			}
			
			array[p.x][p.y] -= d * cnt;
		}
	}
}
```