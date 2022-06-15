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