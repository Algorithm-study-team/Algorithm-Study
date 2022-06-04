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