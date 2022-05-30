<h2>1719: 택배</h2>

https://www.acmicpc.net/problem/1719

<h2>설계</h2>
풀이: 플로이드

모든정점에서 다른 모든 정점의 최단거리를 구하면서 거쳐야하는 집하장을 저장한다.

<h2>코드</h2>

```python
import sys
input = sys.stdin.readline

N,M = map(int,input().split())
array = [[int(1e9)] * (N+1) for _ in range(N+1)]
d = [[j for j in range(N+1)] for _ in range(N+1)]

for i in range(1,N+1):
    array[i][i] = 0

for _ in range(M):
    x,y,z = map(int,input().split())
    array[x][y] = z
    array[y][x] = z

def flow():
    for k in range(1,N+1):
        d[k][k] = '-'
        for i in range(1,N+1):
            for j in range(1,N+1):
                if array[i][k]+array[k][j] < array[i][j]:
                    array[i][j] = array[i][k]+array[k][j]
                    d[i][j] = d[i][k]
flow()

for i in d[1:]:
    print(*i[1:])
```