<h2>14503: 로봇청소기</h2>

https://www.acmicpc.net/problem/14503

<h2>설계</h2>
시간복잡도: O(N*M)

풀이: 시뮬레이션

1.현재 위치를 청소한다.
2.현재 위치에서 다음을 반복하면서 인접한 칸을 탐색한다.
    a.현재 위치의 바로 왼쪽에 아직 청소하지 않은 빈 공간이 존재한다면, 왼쪽 방향으로 회전한 다음 한 칸을 전진하고 1번으로 돌아간다. 그렇지 않을 경우, 왼쪽 방향으로 회전한다. 이때, 왼쪽은 현재 바라보는 방향을 기준으로 한다.
    b.1번으로 돌아가거나 후진하지 않고 2a번 단계가 연속으로 네 번 실행되었을 경우, 바로 뒤쪽이 벽이라면 작동을 멈춘다. 그렇지 않다면 한 칸 후진한다.
위는 로봇청소기가 움직이는 조건이다.

go 메서드에서는 2.a의 작업을 진행하며

"그렇지 않을 경우, 왼쪽 방향으로 회전한다. 이때, 왼쪽은 현재 바라보는 방향을 기준으로 한다."
라는 조건이 성립한다면 로봇청소기는 제자리에서 계속 회전을 하고 있다.
이렇게 제자리 회전을 4회 이상 진행한다면

back 메서드를 실행시켜서 2.b 조건을 진행한다.

<h2>코드</h2>

```java
package algo;

import java.io.*;
import java.util.*;

public class BJ_로봇청소기_14503_G5 {
	static int N,M,R,C,D,cnt,result;
	static int[][] array;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException{ 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		array = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		go();
		clean();
		System.out.println(result);
	}
	
	private static void clean() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(array[i][j] == 2) {
					result++;
				}
			}
		}
	}
	
	private static boolean back(int d, int x, int y) {
			 if(d == 3) {
				 d = 1;
				 // 벽일 경우 
				 if(array[x][y+dy[d]] == 1) {
					 return false;
				 }else {
					 C = y+dy[d];
				 }
			 }else if(d == 2) {
				 d = 0;
				 if(array[x+dx[d]][y] == 1) {
					 return false;
				 }else {
					 R = x+dx[d];
				 }
				 
			 }else if(d == 1) {
				 d = 3;
				 if(array[x][y+dy[d]] == 1) {
					 return false;
				 }else {
					 C = y+dy[d];
				 }
				 
			 }else if(d == 0) {
				 d = 2;
				 if(array[x+dx[d]][y] == 1) {
					 return false;
				 }else {
					 R = x+dx[d];
				 }
			 }
		return true;

	}
	
	private static void go() {
		
		while(true) {
			cnt = 0;
			// 현재 위치 청소
			array[R][C] = 2;
			
			for (int i = 0; i < 4; i++) {
				if(D == 0) {
					D = 3;
				}else if(1 <= D) {
					D -= 1;
				}
				
				if(D == 3 || D == 1) {
					if(0 <= C+dy[D] && C+dy[D] < M) {
						if(array[R][C+dy[D]] == 0) {
							C = C+dy[D];
							array[R][C] = 2;
							break;
						}
					}
				}else if(D == 2 || D == 0) {
					if(0 <= R+dx[D] && R+dx[D] < N) {
						if(array[R+dx[D]][C] == 0) {
							R = R+dx[D];
							array[R][C] = 2;
							break;
						}
					}
				}
				
				cnt++;
			}
			
			if(cnt == 4) {
				if(!back(D,R,C)) {
					break;
				}
			}
		}
	}
}
```