<h2>22255: 호석 사우루스</h2>

https://www.acmicpc.net/problem/22255

<h2>설계</h2>
풀이: 다익스트라

출발지점에서 도착지점까지 최단거리를 구하는 문제로 bfs와 다익스트라 중에 알고리즘을 선택할 수 있다.

하지만 도착지점까지의 최소 충격량인 최소 가중치에 따라 이동해야하므로 다익스트라를 선택하여 문제를 풀 수 있다.

3K, 3K+1, 3K+2와 같이 상황에 따라서 이동 할 수 있는 경우의 수가 3개가 있으므로

가중치를 관리하는 배열을 3차원으로 생성하여 각각의 상태에 따라서 이동 할 수 있도록 한다.

<h2>코드</h2>

```python
import sys,heapq
input = sys.stdin.readline

N,M = map(int,input().split())
sx,sy,ex,ey = map(int,input().split())
array = [list(map(int,input().split())) for _ in range(N)]
dist = [[[int(1e9)] * 3 for _ in range(M)] for _ in range(N)]
dx = [[-1,1,0,0],[-1,1],[0,0]]
dy = [[0,0,-1,1],[0,0],[-1,1]]

def dijkstra():
    q = []
    heapq.heappush(q,(0,1,sx-1,sy-1))
    dist[sx-1][sy-1][0] = 0
       
    while q:
        cost,state,x,y = heapq.heappop(q)
        
        if x == ex-1 and y == ey-1:
            return cost

        for i in range(len(dx[state])):
            nx,ny = x+dx[state][i],y+dy[state][i]
            
            if 0<=nx<N and 0<=ny<M:
                if array[nx][ny] != -1:
                    s = (state+1) % 3
                    c = cost+array[nx][ny]
                    if dist[nx][ny][state] <= c: continue
                    dist[nx][ny][state] = c
                    heapq.heappush(q,(c,s,nx,ny))
    return -1

print(dijkstra())
```