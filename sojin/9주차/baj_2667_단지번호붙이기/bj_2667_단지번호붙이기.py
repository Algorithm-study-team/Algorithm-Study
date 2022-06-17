import sys
sys.setrecursionlimit(10**7)

deltas = [[-1, 0], [1, 0], [0, -1], [0, 1]]


def isIn(r, c):
    return r >= 0 and c >= 0 and r < N and c < N


def dfs(r, c, temp):
    # 방문체크
    array[r][c] = 0

    global deltas

    for d in range(4):
        nr = r+deltas[d][0]
        nc = c+deltas[d][1]
        if isIn(nr, nc) and array[nr][nc] == 1:
            cnt[temp] += 1
            dfs(nr, nc, temp)


N = int(input())
# 초기배열 생성
array = [[]*N for _ in range(N)]

for i in range(N):
    str = input()
    for k in range(len(str)):
        array[i].append(int(str[k]))

cnt = []
temp = 0

for i in range(N):
    for j in range(N):
        if array[i][j] == 1:
            cnt.append(1)
            dfs(i, j, temp)
            temp += 1

cnt.sort()
print(temp)
for i in cnt:
    print(i)
