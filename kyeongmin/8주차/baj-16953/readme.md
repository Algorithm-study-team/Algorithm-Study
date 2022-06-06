<h2>16953: A->B</h2>

https://www.acmicpc.net/problem/16953

<h2>설계</h2>
풀이: bfs

입력 받은 A가 2를 곱하는 경우와 1을 오른쪽에 추가하는 경우를

너비 우선 탐색을 진행하여 구한다.

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