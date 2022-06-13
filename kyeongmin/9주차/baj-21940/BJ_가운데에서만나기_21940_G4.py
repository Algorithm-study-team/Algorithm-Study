import sys
input = sys.stdin.readline

N,M = map(int,input().split())
array = [[int(1e9)] * (N+1) for _ in range(N+1)]

for i in range(N+1):
    array[i][i] = 0

for i in range(M):
    a,b,c = map(int,input().split())
    array[a][b] = c

def flow():
    for k in range(1,N+1):
        for i in range(1,N+1):
            for j in range(1,N+1):
                array[i][j] = min(array[i][j],array[i][k]+array[k][j])

flow()

K = int(input())
f = list(map(int,input().split()))
m = int(1e9)
result = set()

for i in range(1,N+1):
    t = 0
    for h in f:
        if h == i: continue
        # 왕복중 최대값
        t = max(array[h][i]+array[i][h],t)

    if t == m:
        result.add(i)
    # 각 도시에서 최대인 왕복값중 최소값
    elif t < m:
        result = set()
        result.add(i)
        m = t

print(*sorted(result))