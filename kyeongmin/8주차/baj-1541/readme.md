<h2>1541: 잃어버린 괄호</h2>

https://www.acmicpc.net/problem/1541

<h2>설계</h2>
풀이: 그리디

'-'를 기준으로 split를 해서 인덱스 0번에 저장되어있는 숫자는 모두 더하고 나머지 수를 모두 뺀다
 
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