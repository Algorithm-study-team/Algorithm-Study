<h2>15486: 퇴사2</h2>

https://www.acmicpc.net/problem/15486

<h2>설계</h2>
풀이: DP

점화식

이미 상담 받았던 값

temp = max(temp,dp[i])

메모이제이션 리스트에 저장된 값과

현재 상담 받는 값과 이미 상담을 받은 값들을 더한걸 비교

dp[a[i][0]+i] = max(a[i][1]+temp,dp[a[i][0]+i])

<h2>코드</h2>

```python
import sys
input = sys.stdin.readline

N = int(input())
a = [list(map(int,input().split())) for _ in range(N)]
dp = [0] * (N+1)
temp = 0

for i in range(N):
    temp = max(temp,dp[i])

    if a[i][0]+i <= N:
        dp[a[i][0]+i] = max(a[i][1]+temp,dp[a[i][0]+i])

print(max(dp))
```