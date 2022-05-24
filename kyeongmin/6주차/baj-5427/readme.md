<h2>5427: 불</h2>

https://www.acmicpc.net/problem/5427

<h2>설계</h2>
풀이: BFS

불을 저장할 Queue와 상근이의 이동을 저장할 Queue를 생성하고
먼저 불을 상하좌우로 퍼트린 후 상근이를 이동 시킨다.

<h2>코드</h2>

```python
import sys
from collections import deque
input = sys.stdin.readline

T = int(input())
dx = [-1,0,1,0]
dy = [0,1,0,-1]
result = []

def bfs(x,y,q2):
    q = deque()
    q.append((x,y,0))
    visited[x][y] = True

    while q:
        size = len(q2)
        # 불 먼저 이동
        for _ in range(size):
            x,y = q2.popleft()

            for i in range(4):
                nx,ny = x+dx[i],y+dy[i]
                if 0<=nx<N and 0<=ny<M:
                    if array[nx][ny] == '.':
                        array[nx][ny] = '*'
                        q2.append((nx,ny))

        l = len(q)
        for _ in range(l):
            x,y,cnt = q.popleft()

            for i in range(4):
                nx,ny = x+dx[i],y+dy[i]

                if 0<=nx<N and 0<=ny<M:
                    if array[nx][ny] == '.' and not visited[nx][ny]:
                        visited[nx][ny] = True
                        q.append((nx,ny,cnt+1))
                else:
                    return cnt+1

    return "IMPOSSIBLE"

for t in range(T):
    M,N = map(int,input().split())
    X,Y = 0,0
    array = [list(map(str,input().strip())) for _ in range(N)]
    q2 = deque()
    
    for i in range(N):
        for j in range(M):
            if array[i][j] == '@':
                X,Y = i,j
                array[i][j] = '.'
            elif array[i][j] == '*':
                q2.append((i,j))

    visited = [[False] * M for _ in range(N)]

    result.append(bfs(X,Y,q2))

for r in result:
    print(r)

```