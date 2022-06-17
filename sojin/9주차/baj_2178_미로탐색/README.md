<h2>문제이름:bj 미로탐색(S1)</h2>

https://www.acmicpc.net/problem/2178

<h2>설계</h2>

- BFS

  - bfs을 사용한 문제로 deque로 queue를 만들고 초기값을 넣어준다.
  - 다음에 갈 길에 이전길+1을 해주었다.
  - map 사용 : a = list(map(int, a)) 이면 리스트인 a의 모든 요소를 int를 사용해 변환한다. 그리고 list(map)으로 다시 list로 만들어줌
  - array.append(list(map(int, input()))) 도 역시 input()라는 리스트를 int로 바꾸고 그걸 다시 list로 변환

```python
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


```

