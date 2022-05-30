import sys
input = sys.stdin.readline

N,M = map(int,input().split())
array = [[int(1e9)] * (N+1) for _ in range(N+1)]
d = [[j for j in range(N+1)] for _ in range(N+1)]

for i in range(1,N+1):
    array[i][i] = 0

for _ in range(M):
    x,y,z = map(int,input().split())
    array[x][y] = z
    array[y][x] = z

def flow():
    for k in range(1,N+1):
        d[k][k] = '-'
        for i in range(1,N+1):
            for j in range(1,N+1):
                if array[i][k]+array[k][j] < array[i][j]:
                    array[i][j] = array[i][k]+array[k][j]
                    d[i][j] = d[i][k]
flow()

for i in d[1:]:
    print(*i[1:])