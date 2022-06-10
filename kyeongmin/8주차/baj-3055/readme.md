<h2>3055: 탈출</h2>

https://www.acmicpc.net/problem/3055

<h2>설계</h2>
풀이: BFS

백준의 5427 불과 같은 유형의 문제로

물의 이동을 queue에 저장하여 물을 먼저 이동시키고

고슴도치를 이동 시킨다.


<h2>코드</h2>

```python
import sys
from collections import deque
input = sys.stdin.readline

R,C = map(int,input().split())

array = [list(map(str,input().strip())) for _ in range(R)]
visited = [[False] * C for _ in range(R)]

dx = [-1,0,1,0]
dy = [0,1,0,-1]

w = deque()
X,Y,Dx,Dy = 0,0,0,0

for i in range(R):
    for j in range(C):
        if array[i][j] == '*':
            w.append((i,j))
        elif array[i][j] == 'S':
            X,Y = i,j
        elif array[i][j] == 'D':
            Dx,Dy = i,j
            
def water():
    for _ in range(len(w)):
        x,y = w.popleft()
        for i in range(4):
            nx,ny = x+dx[i],y+dy[i]
            if 0<=nx<R and 0<=ny<C:
                if array[nx][ny] == '.':
                    array[nx][ny] = '*' 
                    w.append((nx,ny))

def bfs(x,y):
    q = deque()
    q.append((x,y,0))
    visited[x][y] = True
    
    while q:
        water()            
        
        for _ in range(len(q)):
            x,y,cnt = q.popleft()
            
            for i in range(4):
                nx,ny = x+dx[i],y+dy[i]
                
                if 0<=nx<R and 0<=ny<C:
                    if array[nx][ny] == '.':
                        if not visited[nx][ny]:
                            visited[nx][ny] = True
                            q.append((nx,ny,cnt+1))
                    elif array[nx][ny] == 'D':
                        return cnt+1
        
    return "KAKTUS"

print(bfs(X,Y))
```