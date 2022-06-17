<h2>문제이름:bj 단지번호붙이기(S1)</h2>

https://www.acmicpc.net/problem/2667

<h2>설계</h2>

- dfs

  - 깊게 들어가서 탐색하는거라고 생각해서 재귀를 이용해서 dfs로 풀어야겠다고 생각했다. 
  - temp을 이용해서 배열에 임의로 수를 지정해주었다. 
  - cnt.append()을 이용해서 새로 생성되는 배열을 지정 

```python
import sys
sys.setrecursionlimit(10**7)

deltas = [[-1, 0], [1, 0], [0, -1], [0, 1]]


def isIn(r, c):
    return r >= 0 and c >= 0 and r < N and c < N


def dfs(r, c, temp):
    # 방문체크
    array[r][c] = 0

    global deltas

    for d in range(4):
        nr = r+deltas[d][0]
        nc = c+deltas[d][1]
        if isIn(nr, nc) and array[nr][nc] == 1:
            cnt[temp] += 1
            dfs(nr, nc, temp)


N = int(input())
# 초기배열 생성
array = [[]*N for _ in range(N)]

for i in range(N):
    str = input()
    for k in range(len(str)):
        array[i].append(int(str[k]))

cnt = []
temp = 0

for i in range(N):
    for j in range(N):
        if array[i][j] == 1:
            cnt.append(1)
            dfs(i, j, temp)
            temp += 1

cnt.sort()
print(temp)
for i in cnt:
    print(i)


```

