<h2>14923: 미로탈출</h2>

https://www.acmicpc.net/problem/14923

<h2>설계</h2>
시간복잡도: O(N*M)

알고리즘: BFS

위치(x,y), 지팡이 사용유무를 체크하기위한 3차원 배열을 생성하여 처리 

<h2>코드</h2>

₩₩₩

import java.io.*;  
import java.util.*;

public class BJ_미로탈출_14923_G4 {
    static int N,M,hx,hy,ex,ey,count;
    static int[][] array;
    static boolean[][][] visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static class Point {
        int x, y, cnt, use;

        public Point(int x, int y, int cnt, int use){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.use = use;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        hx = Integer.parseInt(st.nextToken())-1;
        hy = Integer.parseInt(st.nextToken())-1;

        st = new StringTokenizer(br.readLine());
        ex = Integer.parseInt(st.nextToken())-1;
        ey = Integer.parseInt(st.nextToken())-1;

        array = new int[N][M];
        visited = new boolean[N][M][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs());
    }

    private static int bfs(){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(hx,hy,0,0));
        visited[hx][hy][0] = true;

        while(!q.isEmpty()){
            Point p = q.poll();

            if(p.x == ex && p.y == ey){
                count = p.cnt;
                return count;
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if(0<=nx && nx<N && 0<=ny && ny<M){
                    if(array[nx][ny] == 1 && p.use == 0){
                        if(!visited[nx][ny][1]){
                            visited[nx][ny][1] = true;
                            q.add(new Point(nx,ny,p.cnt+1,1));
                        }
                    }else if(array[nx][ny] == 0){
                        if(!visited[nx][ny][p.use]){
                            visited[nx][ny][p.use] = true;
                            q.add(new Point(nx,ny,p.cnt+1,p.use));
                        }
                    }
                }
            }
        }

        return -1;
    }
}
₩₩₩
