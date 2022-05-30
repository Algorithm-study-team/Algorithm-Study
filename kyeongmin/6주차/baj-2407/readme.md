<h2>2407: 조합</h2>

https://www.acmicpc.net/problem/2407

<h2>설계</h2>
풀이: DP

nCn과 nC0은 모두 1로 저장한다.

점화식 nCr = n-1Cr-1+n-1Cr

<h2>코드</h2>

```python
import sys
input = sys.stdin.readline

N,M = map(int,input().split())
cnt = 0
dp = [[0] * (101) for _ in range(101)]

for i in range(1,101):
    dp[i][i] = 1
    dp[i][0] = 1

for i in range(1,101):
    for j in range(1,i):
        dp[i][j] = dp[i-1][j-1]+dp[i-1][j]

print(dp[N][M])
```