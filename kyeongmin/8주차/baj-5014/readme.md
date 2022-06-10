<h2>5014: 스타트링크</h2>

https://www.acmicpc.net/problem/5014

<h2>설계</h2>
풀이: BFS

queue에 U 버튼을 누를 경우와 D 을 누르는 경우를 Queue 에 저장하며 

G 에 도착했을 경우 끝낸다.

<h2>코드</h2>

```python
import sys
from collections import deque
input = sys.stdin.readline

F, S, G, U, D = map(int,input().split())
visited = [False] * (F+1) 

def bfs():
    q = deque()
    q.append((S,0))
    visited[0] = True
    visited[S] = True    
    
    while q:
        s,cnt = q.popleft()
        
        if s == G:
            return cnt
        
        if U:
            if 1<= s+U <= F and not visited[s+U]:
                visited[s+U] = True
                q.append((s+U,cnt+1))
        
        if D:
            if 1<= s-D <= F and not visited[s-D]: 
                visited[s-D] = True
                q.append((s-D,cnt+1))
                
    return "use the stairs"

print(bfs())
```