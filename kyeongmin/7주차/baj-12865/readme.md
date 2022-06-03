<h2>12865: 평범한배낭</h2>

https://www.acmicpc.net/problem/12865

<h2>설계</h2>
풀이: DP

2차원 점화식

입력 받은 무게와 가치 순서대로

무게가 1부터 K+1까지 배낭에 무게를 넣을 수 있을 경우에

전에 넣었던 무게와 현재 넣을 수 있는 모든 무게의 합을 비교하여 저장한다.

1차원 점화식

입력 받은 리스트를 무게 순으로 정렬하고

1차원 배열 인덱스만큼 넣을 수 있는 무게의 가치를 저장한다.

인덱스 크기만큼 들어갈 수 있는 무게로 생각한다.

현재 무게의 크기 만큼의 인덱스에 들어가있는 가치와 넣을 수 있는 무게의 가치의 합과

현재 인덱스에 들어가있는 가치와 비교한다.


<h2>코드</h2>

```python
import sys
input = sys.stdin.readline

N,K = map(int, input().split())

array = [[0,0]]
dp = [[0] * (K+1) for _ in range(N+1)]

for i in range(N):
    array.append(list(map(int,input().split())))

# 2차원 dp
def knapscak():
    for i in range(1,N+1):
        w = array[i][0]
        v = array[i][1]
        for j in range(1,K+1): 
            if j < w:
                dp[i][j] = dp[i-1][j]
            else:
                dp[i][j] = max(dp[i-1][j], dp[i-1][j-w]+v)
                
knapscak()
print(dp[N][K])

# 1차원 dp
import sys
input = sys.stdin.readline

N,K = map(int, input().split())

array = []
dp = [0] * (K+1)

for i in range(N):
    array.append(list(map(int,input().split())))

def knapscak():
    for w,v in array:
        for i in range(K,w-1,-1):
            dp[i] = max(dp[i],dp[i-w]+v)
            
array.sort()  
knapscak()
print(dp[K])
```