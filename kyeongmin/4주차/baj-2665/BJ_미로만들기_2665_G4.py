import sys,heapq
input = sys.stdin.readline

N = int(input())
array = [list(map(str,input())) for _ in range(N)]
visited = [[-1] * N for _ in range(N)]
dx = [-1,0,1,0]
dy = [0,1,0,-1]

def dijkstra():
    q = []
    heapq.heappush(q,(0,0,0))
    visited[0][0] = 0

    while q:
        cnt,x,y = heapq.heappop(q)

        if x == N-1 and y == N-1:
            break

        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]

            if 0<=nx<N and 0<=ny<N:
                if visited[nx][ny] == -1:
                    visited[nx][ny] = cnt
                    if array[nx][ny] == '0':
                        heapq.heappush(q,(cnt+1,nx,ny))
                    else:
                        heapq.heappush(q,(cnt,nx,ny))

dijkstra()
print(visited[N-1][N-1])