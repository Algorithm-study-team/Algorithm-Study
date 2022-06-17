from collections import deque


def isIn(nr, nc):
    return nr >= 0 and nc >= 0 and nr < R and nc < C


def bfs(r, c):
    deltas = [[-1, 0], [1, 0], [0, -1], [0, 1]]
    queue = deque()
    queue.append((r, c))

    while queue:
        r1, c1 = queue.popleft()
        if r1 == R-1 and c1 == C-1:
            return array[r1][c1]
        for d in range(4):
            nr = r1+deltas[d][0]
            nc = c1+deltas[d][1]

            if isIn(nr, nc) and array[nr][nc] == 1:
                queue.append((nr, nc))
                array[nr][nc] = array[r1][c1]+1


R, C = map(int, input().split())
array = []

for _ in range(R):
    array.append(list(map(int, input())))

print(bfs(0, 0))
