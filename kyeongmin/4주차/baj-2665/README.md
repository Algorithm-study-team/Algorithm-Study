<h2>2665: 미로만들기</h2>

https://www.acmicpc.net/problem/2665

<h2>설계</h2>
다익스트라 시간복잡도: O(NlogN)

풀이: 다익스트라

시작점(0,0)에서 도착점(N-1,N-1)까지 도착해야한다.
하얀방에서 검은방으로 변경할 수 있는 개수가 제한되어 있지않다.
현재 문제는 시작점에서 도착점까지 방을 최소한으로 바꿔서 가야한다.
이 의미는 시작점부터 도착점까지의 최소비용으로 가야한다는 의미와 같다고 생각했다.
그러므로 다익스트라 알고리즘을 사용하여 문제를 풀어보았다.

1. 우선순위 큐를 사용하여 하얀방에서 검은방을 바꾼 수가 최소인것부터 가져와서 탐색을 한다.
2. 현재 위치에서까지 방을 바꾼 개수를 4방향을 돌며 갱신이 안된곳에 저장시킨다. - 최소값을 저장시키기 위해서

<h2>코드</h2>

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ_미로만들기_2665_G4 {
    static int N;
    static char[][] array;
    static int[][] d;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static class Point implements Comparable<Point>{
        int x,y,d;

        public Point(int x, int y, int d){
            this.x = x;
            this.y = y;
            this.d = d;
        }

        @Override
        public int compareTo(Point p){
            return this.d - p.d;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        array = new char[N][N];
        d = new int[N][N];

        for(int i=0; i<N; i++){
            array[i] = br.readLine().toCharArray();
        }

        for(int i=0; i<N; i++){
            Arrays.fill(d[i],-1);
        }

        dijkstra();
        System.out.println(d[N-1][N-1]);
    }

    private static void dijkstra(){
        PriorityQueue<Point> pq = new PriorityQueue<>();
        pq.add(new Point(0,0,0));
        d[0][0] = 0;

        while(!pq.isEmpty()){
            Point p = pq.poll();

            for(int i=0; i<4; i++){
                int nx = p.x+dx[i];
                int ny = p.y+dy[i];

                if(0<=nx && nx<N && 0<=ny && ny<N){
                    if(d[nx][ny] == -1){
                        d[nx][ny] = p.d;
                        if(array[nx][ny] == '1'){
                            pq.add(new Point(nx,ny,p.d));
                        }else{
                            pq.add(new Point(nx,ny,p.d+1));
                        }
                    }
                }
            }
        }

    }
}
```


```python
import sys,heapq
input = sys.stdin.readline

N = int(input())
array = [list(map(str,input())) for _ in range(N)]
visited = [[False] * N for _ in range(N)]
dx = [-1,0,1,0]
dy = [0,1,0,-1]

def dijkstra():
    q = []
    heapq.heappush(q,(0,0,0))
    visited[0][0] = True

    while q:
        cnt,x,y = heapq.heappop(q)
        
        if x == N-1 and y == N-1:
            return cnt
        
        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]
            
            if 0<=nx<N and 0<=ny<N:
                if not visited[nx][ny]:
                    if array[nx][ny] == '0':
                        array[nx][ny] = '1'
                        visited[nx][ny] = True
                        heapq.heappush(q,(cnt+1,nx,ny))
                    else:
                        visited[nx][ny] = True
                        heapq.heappush(q,(cnt,nx,ny))
print(dijkstra())
```