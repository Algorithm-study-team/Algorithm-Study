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