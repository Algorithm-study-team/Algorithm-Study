<h2>21278: 호석이 두마리 치킨</h2>

https://www.acmicpc.net/problem/21278

<h2>설계</h2>
시간복잡도: O(N^3)

풀이: 플로이드 워셜

다익스트라는 하나의 정점에서 다른 모든 정점까지의 최단 거리를 구하는 알고리즘이나
플로이드 워셜은 한번 실행하여 모든 노드 간 최단 거리를 구할 수 있다.

1. 플로이드 워셜로 모든 노드 간 최단 거리를 구한다.
2. 조합을 사용해서 모든 노드의 두개의 치킨집 경우 수를 구한다.
3. 다른 노드들의 치킨집 둘 중에 가까운 거리 구하기

<h2>코드</h2>

```python
import sys
input = sys.stdin.readline

N,M = map(int,input().split())
array = [list(map(int,input().split())) for _ in range(M)]
result = int(1e9)
d = [[int(1e9)] * (N+1) for _ in range(N+1)]

def flow():
    for i in range(M):
        d[array[i][0]][array[i][1]] = 1
        d[array[i][1]][array[i][0]] = 1

    for k in range(1,N+1):
            d[k][k] = 0
            for i in range(1,N+1):
                for j in range(1,N+1):
                    d[i][j] = min(d[i][j],d[i][k]+d[k][j])

tp = []
def comb(start,idx,choosed):
    if idx == 2:
        result = 0

        for i in range(1,N+1):
            # 치킨집 둘 중에 하나 가까운 거리 구하기
            result += min(d[choosed[0]][i], d[choosed[1]][i])
        tp.append((result * 2,choosed[0],choosed[1]))
        return

    for i in range(start,N+1):
        choosed[idx] = i
        comb(i+1,idx+1,choosed)

flow()
comb(1,0,[0] * 2)
tp.sort()

print(tp[0][1],tp[0][2],tp[0][0])
```