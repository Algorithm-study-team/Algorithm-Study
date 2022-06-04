<h2>1238: 파티</h2>

https://www.acmicpc.net/problem/1238

<h2>설계</h2>
풀이: 다익스트라

1~N+1까지 최단거리를 저장하고

저장된 결과 리스트에서 1~N+1까지 왕복 값중 가장 큰 값을 고른다.

<h2>코드</h2>

```python
import sys,heapq
input = sys.stdin.readline

N,M,X = map(int,input().split())
array = [[] for _ in range(N+1)]
d = [[int(1e9)] * (N+1) for _ in range(N+1)]

for i in range(M):
    a,b,c = map(int,input().split())
    array[a].append((b,c))
    
def dijkstra(start):
    q = []
    heapq.heappush(q,(0,start))
    
    while q:
        dist,x = heapq.heappop(q)
        
        if d[start][x] < dist: continue
        
        for y,w in array[x]:
            cost = dist+w
            
            if cost < d[start][y]:
                d[start][y] = cost
                heapq.heappush(q,(cost,y))
                
for i in range(1,N+1):
    dijkstra(i)
    
result = 0
for i in range(1,N+1):
    if i == X: continue
    if result < d[i][X]+d[X][i]:
        result = d[i][X]+d[X][i]

print(result)
```