<h2>9465: 스티커</h2>

https://www.acmicpc.net/problem/9465

<h2>설계</h2>
풀이: DP

점화식
array[0][i] = max(array[0][i]+array[1][i-2],array[0][i]+array[1][i-1])

array[1][i] = max(array[1][i]+array[0][i-2],array[1][i]+array[0][i-1])

0번 row는 1번 row의 array[1][i-2]와 array[1][i-1]을 비교하고

1번 row는 0번 row의 array[0][i-2]와 array[0][i-1]과 비교한다.

N이 1일때도 고려해야한다.

<h2>코드</h2>

```python
import sys
input = sys.stdin.readline

T = int(input())
result = []

for _ in range(T):
    array = []
    N = int(input())
    for i in range(2):
        array.append(list(map(int,input().split())))
    
    if N == 1:
        print(max(array[0][0],array[1][0]))
        continue
        
    array[0][1] += array[1][0]
    array[1][1] += array[0][0]

    for i in range(2,N):
        array[0][i] = max(array[0][i]+array[1][i-2],array[0][i]+array[1][i-1])
        array[1][i] = max(array[1][i]+array[0][i-2],array[1][i]+array[0][i-1])
        
    result.append(max(array[0][N-1],array[1][N-1]))

for r in result:
    print(r)
```