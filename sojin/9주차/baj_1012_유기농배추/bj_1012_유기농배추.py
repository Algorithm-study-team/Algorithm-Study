import sys
sys.setrecursionlimit(10**8)


def isIn(nr, nc):
    global m, n
    if nr >= 0 and nc >= 0 and nr < m and nc < n:
        return True
    else:
        return False


def dfs(r, c):
    deltas = [[-1, 0], [1, 0], [0, -1], [0, 1]]

    for d in range(4):
        nr = r+deltas[d][0]
        nc = c+deltas[d][1]

        if isIn(nr, nc):
            if array[nr][nc] == 1:
                array[nr][nc] = 0  # 방문체크
                dfs(nr, nc)


T = int(input())
for _ in range(T):
    # n: 열,m: 행,k: 위치개수
    n, m, k = map(int, input().split())
    # 배열 만들기
    array = [[0]*(n) for _ in range(m)]

    for _ in range(k):
        b, a = map(int, input().split())
        array[a][b] = 1

    cnt = 0

    for a in range(m):
        for b in range(n):
            if array[a][b] == 1:
                array[a][b] = 0
                dfs(a, b)
                cnt += 1
    print(cnt)
