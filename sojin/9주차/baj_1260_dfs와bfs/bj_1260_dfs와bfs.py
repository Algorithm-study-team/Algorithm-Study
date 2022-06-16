import sys
from collections import deque
input = sys.stdin.readline

# n은 정점의 개수 m은 간선의 개수 v는 탐색 시작 번호
n, m, start = map(int, input().split())

# 몇번노드와 인접해있는지 확인하기 위해 만드는 배열
# [[],[],[],[],...]
graph = [[]for _ in range(n+1)]

for _ in range(m):
    a, b = map(int, input().split())
    # 해당하는 index에 배열 넣어주기 0번 인덱스에 [2,4,6]이면
    # 2,4,6과 인접해 있다.
    graph[a].append(b)
    graph[b].append(a)

# 정점번호가 작은 것 부터 탐색해야하므로 sort() 
for i in range(1, n+1):
    graph[i].sort()


def dfs(n):
    visited[n] = True
    print(n, end=" ")
    for i in graph[n]:
        if not visited[i]:
            dfs(i)


def bfs(n):
    queue = deque([n])
    visited[n] = True
    while queue:
        v = queue.popleft()
        print(v, end=" ")
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True


visited = [False]*(n+1)  # visited배열을 false로 채우기
dfs(start)
print()
visited = [False]*(n+1)  # visited배열을 false로 채우기
bfs(start)
