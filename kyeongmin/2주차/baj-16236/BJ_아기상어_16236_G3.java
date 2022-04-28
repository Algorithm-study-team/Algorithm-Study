package algo;

import java.io.*;
import java.util.*;

public class BJ_아기상어_16236_G3 {
	static int N,X,Y,S,C,cnt,result,d;
	static int[][] array;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static List<Point> fish = new ArrayList<>();
	static List<Shark> shark = new ArrayList<>();
	
	public static class Shark {
		int x,y,d;
		
		public Shark(int x, int y,   int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}
	}
	
	public static class Point implements Comparable<Point> {
		int x,y,size,d,cnt;
		
		public Point(int x, int y, int size, int d) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.d = d;
		}
		
		@Override
		public int compareTo(Point p) {
			if(this.d == p.d) {
				if(this.x == p.x) {
					return Integer.compare(this.y, p.y);
				}else {
					return Integer.compare(this.x, p.x);
				}
			}else {
				return Integer.compare(this.d, p.d);
			}	
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		array = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				
				if(array[i][j] == 9) {
					X = i;
					Y = j;
					S = 2;
					array[i][j] = 0;
				}
			}
		}
		
		bfs();			
		System.out.println(result);
		
	}
	
	private static void bfs() {
		
		while(true) {
			Queue<Shark> q = new LinkedList<>();
			q.add(new Shark(X,Y,0));
			visited = new boolean[N][N];
			visited[X][Y] = true;
			
			while(!q.isEmpty()) {
				Shark s = q.poll();
				
				for (int i = 0; i < 4; i++) {
					int nx = s.x+dx[i];
					int ny = s.y+dy[i];
					
					if(0<=nx && nx<N && 0<=ny && ny<N) {
						if(!visited[nx][ny]) {
							// 물고기가 없는 경우
							if(array[nx][ny] == 0 || array[nx][ny] == S) {
								visited[nx][ny] = true;
								q.add(new Shark(nx,ny,s.d+1));
							} else if(array[nx][ny] < S) {
								visited[nx][ny] = true;
								fish.add(new Point(nx,ny,array[nx][ny],s.d+1));
							}
						}
					}
				}
				
			}
			
			Collections.sort(fish);
			// 물고기가 있는 경우
			if(!fish.isEmpty()) {
				cnt++;
				// 사이즈와 물고기 먹은 수가 같으면 상어 사이즈 
				if(cnt == S) {
					S++;
					cnt = 0;
				}
				
				// 마지막 물고기의 자리 = 상어 자리
				X = fish.get(0).x;
				Y = fish.get(0).y;
				// 물고기까지의 거리
				result += fish.get(0).d;
				// 먹은 물고기 지우기
				array[X][Y] = 0;
				
				// 최단거리 한번씩 가기 위해
				fish.clear();
				
			// 먹을 물고기가 없을 경
			}else {
				break;
				}
			}
		}	
	}
