import java.io.*;
import java.util.*;

public class BJ_단지번호붙이기_2667_S1 {
    static int N,count;
    static char[][] array;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> list = new ArrayList<>();
        N = Integer.parseInt(st.nextToken());
        array = new char[N][N];
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            array[i] = br.readLine().toCharArray();
        }

        int danji = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(!visited[i][j] && array[i][j] == '1'){
                    count = 1;
                    danji++;
                    visited[i][j] = true;
                    dfs(i,j);
                    list.add(count);
                }
            }
        }

        Collections.sort(list);
        System.out.println(danji);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    private static void dfs(int x, int y){
        for (int i = 0; i < 4; i++) {
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(0<=nx && nx<N && 0<=ny && ny<N){
                if(!visited[nx][ny] &&
                        array[nx][ny] == '1'){
                    visited[nx][ny] = true;
                    count++;
                    dfs(nx,ny);
                }
            }
        }
    }
}