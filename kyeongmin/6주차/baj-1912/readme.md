<h2>1912: 연속합</h2>

https://www.acmicpc.net/problem/1912

<h2>설계</h2>
풀이: DP

메모이제이션 리스트를 입력 받은 최소 값으로 배열로 생성 후

현재 인덱스의 값과 왼쪽부터 더한 값을 합한 결과와

현재 인덱스의 값과 비교하여 큰 값을 저장한다.

<h2>코드</h2>

```python
import sys
input = sys.stdin.readline

N = int(input())
array = list(map(int,input().split()))
dp = [min(array)] * 100001
dp[0] = array[0]

for i in range(1,N):
    dp[i] = max(array[i]+dp[i-1],array[i])

print(max(dp))
```