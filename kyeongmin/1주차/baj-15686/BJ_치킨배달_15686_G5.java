import java.io.*;
import java.util.*;

public class BJ_치킨배달_15686_G5 {
    static int N,M;
    static int[][] array;
    static List<Point> chi,house;
    static int result,rTemp,temp;

    public static class Point {
        int x,y;

        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        array = new int[N][N];
        house = new ArrayList<>();
        chi = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());

                if(array[i][j] == 1){
                    house.add(new Point(i,j));
                }else if(array[i][j] == 2){
                    chi.add(new Point(i,j));
                }
            }
        }

        result = Integer.MAX_VALUE;
        comb(0,0,new ArrayList<>(),new boolean[N][N]);
        System.out.println(result);
    }

    private static void comb(int start, int idx, List<Point> choosed, boolean[][] visited){
        if(idx == M){
            go(choosed);
            return;
        }

        for (int i = start; i < chi.size(); i++) {
            if(!visited[chi.get(i).x][chi.get(i).y]){
                visited[chi.get(i).x][chi.get(i).y] = true;
                choosed.add(chi.get(i));
                comb(i+1,idx+1,choosed,visited);
                visited[chi.get(i).x][chi.get(i).y] = false;
                choosed.remove(choosed.size()-1);
            }
        }
    }

    private static void go(List<Point> choosed){
        rTemp = 0;
        for(Point h: house){
            temp = Integer.MAX_VALUE;
            for(Point c: choosed){
                int len = Math.abs(Math.abs(h.x-c.x)+Math.abs(h.y-c.y));
                // 각각의 집에서 치킨-집 가장 가까운 거리
                temp = Math.min(temp,len);
            }
            // 하나의 경우의 수 중에서 각각의 집에서 치킨집까지 가까운 거리 더함
            rTemp += temp;
        }

        // 하나의 경우의 수 모든 치킨-집 가장 가까운 거리
        result = Math.min(result,rTemp);
    }
}