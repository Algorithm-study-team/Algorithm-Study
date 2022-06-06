<h2>1758: 알바생 강호</h2>

https://www.acmicpc.net/problem/1758

<h2>설계</h2>
풀이: 그리디

가장 큰 값이 맨 앞으로 오기 위해서
내림차순으로 정렬을 진행한다.

<h2>코드</h2>

```python
import sys
input = sys.stdin.readline

N = int(input())
array = [int(input()) for _ in range(N)]
array.sort(reverse = True)
result = 0

for i in range(N):
    if 0 < array[i]-i:
        result += array[i]-i

print(result)
```