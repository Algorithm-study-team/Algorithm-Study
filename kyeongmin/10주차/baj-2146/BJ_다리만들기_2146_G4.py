import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
array = [list(map(int,input().split())) for _ in range(N)]
dx = [-1,0,1,0]
dy = [0,1,0,-1]

def bfs(x,y,cnt):
    q = deque()
    q.append((x,y))
    array[x][y] = cnt
    
    while q:
        x,y = q.popleft()
        
        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]
            
            if 0<=nx<N and 0<=ny<N:
                if array[nx][ny] == 1:
                    array[nx][ny] = cnt
                    q.append((nx,ny))
                    
cnt = 1
result = int(1e9)
for i in range(N):
    for j in range(N):
        if array[i][j] == 1:
            cnt+=1
            bfs(i,j,cnt)

def check(h):
    global result
    visited = [[-1] * N for _ in range(N)]

    q = deque()
    for i in range(N):
        for j in range(N):
            if array[i][j] == h:
                q.append((i,j))
    
    while q:
        x,y = q.popleft()
        
        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]
            
            if 0<=nx<N and 0<=ny<N:
                if array[nx][ny] == 0 and visited[nx][ny] == -1:
                    visited[nx][ny] = visited[x][y]+1   
                    q.append((nx,ny))
                elif array[nx][ny] != h and array[nx][ny]:    
                    result = min(result,visited[x][y]+1)
                    return
                
for i in range(2,cnt+1):
    check(i)
    
print(result)