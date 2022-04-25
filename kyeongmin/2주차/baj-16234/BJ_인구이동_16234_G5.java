package algo;

import java.io.*;
import java.util.*;

public class BJ_인구이동_16234_G5 {
	static int N,L,R,move,count,sum;
	static boolean check;
	static int[][] array;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[][] visited;
	static Queue<Point> list;
	
	public static class Point{
		int x,y;
		
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		array = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			visited = new boolean[N][N];
			check = false;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visited[i][j]) {
						sum = 0;
						bfs(i,j);
						
						if(1 < count) {
							go();	
							check = true;
						}
					}
				}
			}
			
			if(!check) {
				break;
			}else {
				move++;
			}
		}
		
		System.out.println(move);
		
	}
	
	private static void go() {
		int tp = (int)(sum/count);
		
		for(Point p:list) {
			array[p.x][p.y] = tp;
		}
	}
	
	private static void bfs(int x, int y) {
		Queue<Point> q = new LinkedList();
		list = new LinkedList();
		list.add(new Point(x,y));
		q.add(new Point(x,y));
		visited[x][y] = true;
		sum = array[x][y];
		count = 1;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nx = p.x+dx[i];
				int ny = p.y+dy[i];
				
				if(0<=nx && nx<N && 0<=ny && ny<N) {
					if(!visited[nx][ny]) {
						if(L<=Math.abs(array[nx][ny]-array[p.x][p.y]) && Math.abs(array[nx][ny]-array[p.x][p.y]) <=R) {
							visited[nx][ny] = true;
							sum += array[nx][ny];
							count++;
							q.add(new Point(nx,ny));
							list.add(new Point(nx,ny));
						}
					}
				}
			}
		}
		
	}

}
