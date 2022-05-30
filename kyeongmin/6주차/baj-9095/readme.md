<h2>9095: 1,2,3 더하기</h2>

https://www.acmicpc.net/problem/9095

<h2>설계</h2>
풀이: DP

점화식 a(n) = a(n-1)+a(n-2)+a(n-3)

<h2>코드</h2>

```python
import sys
input = sys.stdin.readline

T = int(input())

for i in range(T):
    N = int(input())
    dp = [0] * 100
    dp[1] = 1
    dp[2] = 2
    dp[3] = 4

    for i in range(4,12):
        dp[i] = dp[i-1]+dp[i-2]+dp[i-3]
        if N == i: break
    
    print(dp[N])
```