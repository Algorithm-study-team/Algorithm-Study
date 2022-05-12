<h2>17822: 원판 돌리기</h2>

https://www.acmicpc.net/problem/17822

<h2>설계</h2>

풀이: 시뮬레이션

1. 하나의 행씩 돌리기 위해서 rotate 메소드를 작성하였고
2. 이동이 끝난 후 인접한 곳을 체크한 후 한꺼번에 삭제 하기 위해서 Queue에 저장하였다.
3. 만약에 Queue에 저장된것이 없다면 배열에 0아 아닌 숫자를 평균보다 높으면 증가시키고 낮으면 감소 시켰다.


<h2>코드</h2>

```python
import sys,copy
from collections import deque
input = sys.stdin.readline

N,M,T = map(int,input().split())
array = [list(map(int,input().split())) for _ in range(N)]
time = [list(map(int,input().split())) for _ in range(T)]

dx = [-1,0,1,0]
dy = [0,1,0,-1]

def rotate(tp,x,d,k):
    if d == 0:
        for _ in range(k):
            temp = tp[x][M-1]
            for i in range(M-1,0,-1):
                tp[x][i] = tp[x][i-1]
            tp[x][0] = temp
    elif d == 1:
        for _ in range(k):
            temp = tp[x][0]
            for i in range(0,M-1):
                tp[x][i] = tp[x][i+1]
            tp[x][M-1] = temp

    return tp

# 인접한 것이 있는지 체크하면서 
def move(tp):
    rem = deque()
    visited = [[False] * (M) for _ in range(N)]
    for x in range(N):
        for y in range(M):
            if not visited[x][y]:
                visited[x][y] = True
                for i in range(4):
                    nx,ny = x+dx[i],y+dy[i]
                    if 0<=nx<N:
                        if ny == -1:
                            ny += M
                        elif ny == M:
                            ny = 0
                        if tp[nx][ny] != 0 and tp[x][y] != 0 and tp[nx][ny] == tp[x][y]:
                            rem.append((x,y))
                            rem.append((nx,ny))
    if(rem):
        for x,y in rem:
            tp[x][y] = 0
        return True
    else:
        return False


# 인접한것이 없는 경우
def move2(tp):
    cnt = 0
    tsm = 0

    for i in range(N):      
        for j in range(M):
            if tp[i][j] != 0:
                cnt+=1
                tsm+= tp[i][j]

    if cnt == 0 or tsm == 0: return

    mid = tsm/cnt
    
    for i in range(N):
        for j in range(M):
            if mid < tp[i][j]:
                tp[i][j]-=1
            elif mid > tp[i][j] and tp[i][j] != 0:
                tp[i][j]+=1
def go(time):
    global T,N,array
    for i in range(len(time)):
        x,d,k = time[i][0],time[i][1],time[i][2]
        tk = []
        for i in range(1,N+1):
             if i%x == 0:
                 tk.append(i)

        tp = copy.deepcopy(array)
        for t in tk:
            tp = rotate(tp,t-1,d,k)

        if move(tp) == False:
            move2(tp)

        array = tp

    return array

array = go(time)
result = 0
for arr in array:
    result+=sum(arr)

print(result)
```