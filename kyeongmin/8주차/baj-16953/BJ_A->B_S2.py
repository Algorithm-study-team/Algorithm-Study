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