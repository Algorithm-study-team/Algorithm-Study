<h2>7785: 회사에 있는 사람</h2>

https://www.acmicpc.net/problem/7785

<h2>설계</h2>

풀이: 문자열

딕셔너리에 출근한 사람을 추가하며 퇴근한 사람은 제거 시킨다.

<h2>코드</h2>

```python
import sys
input = sys.stdin.readline

N = int(input())
array = [list(map(str,input().split())) for _ in range(N)]
d = dict()

for x,y in array:
    if y == "leave":
        d.pop(x)
    else:
        d[x] = y
d = sorted(d.items(),reverse = True)

for x,y in d:
    print(x)
```