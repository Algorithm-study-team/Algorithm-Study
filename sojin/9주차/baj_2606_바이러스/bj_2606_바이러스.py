n = int(input())
m = int(input())

array = [[] for _ in range(n+1)]

# 배열 인접 작성
for _ in range(m):
    a, b = map(int, input().split())
    array[a].append(b)
    array[b].append(a)

cnt = 0


def dfs(n):
    visited[n] = True
    global cnt
    for i in array[n]:
        # 아직 방문 안한 False라면?
        if not visited[i]:
            visited[i] = True
            cnt += 1
            dfs(i)


visited = [False]*(n+1)
dfs(1)
print(cnt)
