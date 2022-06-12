<h2>21923: 곡예비행</h2>

https://www.acmicpc.net/problem/21923

<h2>설계</h2>
풀이: DP

상승비행과 하강비행의 DP 테이블을 각각 나눠서 계산한다.

1. 상승 비행의 DP 테이블에 위로 이동할 경우와 오른쪽으로 이동할 경우에 해당하는 값을 저장한다.
2. 하강 비행의 DP 테이블에 아래로 내려갈 경우와 오른쪽으로 이동할 경우에 해당하는 값을 저장한다.
3. 상승 비행의 경로인 현재 위치에서 왼쪽값과 아래에 값을 비교하며 현재 위치의 값을 갱신한다.
4. 하강 비행의 경로인 현재 위치에서 오른쪽값과 아래의 값을 비교하여 현재 위치의 값을 갱신한다.

<h2>코드</h2>

```python
import sys
input = sys.stdin.readline

N,M = map(int,input().split())
array = [list(map(int,input().split())) for _ in range(N)]
dp = [[0] * M for _ in range(N)]
dp2 = [[0] * M for _ in range(N)]

# 상승 비행
dp[N-1][0] = array[N-1][0]
for i in range(N-2,-1,-1):
    dp[i][0] = array[i][0]+dp[i+1][0]

for i in range(1,M):
    dp[N-1][i] = array[N-1][i]+dp[N-1][i-1]
    
for i in range(N-2,-1,-1):
    for j in range(1,M):
        dp[i][j] = array[i][j]+max(dp[i+1][j],dp[i][j-1])

# 하강 비행
dp2[N-1][M-1] = array[N-1][M-1]
for i in range(N-2,-1,-1):
    dp2[i][M-1] = array[i][M-1]+dp2[i+1][M-1]

for i in range(M-2,-1,-1):
    dp2[N-1][i] = array[N-1][i]+dp2[N-1][i+1]

for i in range(N-2,-1,-1):
    for j in range(M-2,-1,-1):
        dp2[i][j] = array[i][j]+max(dp2[i+1][j],dp2[i][j+1])

result = dp[0][0]+dp2[0][0]
for i in range(N):
    for j in range(M):
        result = max(result,dp[i][j]+dp2[i][j])

print(result)
```