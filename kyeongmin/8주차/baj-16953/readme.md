<h2>16953: A->B</h2>

https://www.acmicpc.net/problem/16953

<h2>설계</h2>
풀이: 그리디

queue에 A의 *2, A+"1"인 경우를 B가 될때까지 넣는다.

<h2>코드</h2>

```python
import sys
from collections import deque
input = sys.stdin.readline

A,B = map(int,input().split())
q = deque()
q.append((A,1))

def bfs():
    while q:
        t,cnt = q.popleft()
        
        if t * 2 ==  B or int(str(t)+"1") == B:
            return cnt+1

        if t * 2 < B:
            q.append((t * 2,cnt+1))
        if int(str(t)+"1") < B:
            q.append((int(str(t)+"1"),cnt+1))
            
    return -1

print(bfs())
```