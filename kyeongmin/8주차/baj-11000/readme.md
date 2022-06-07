<h2>11000: 강의실 배정</h2>

https://www.acmicpc.net/problem/11000

<h2>설계</h2>
풀이: 그리디

끝나는 시간이 빠른 순으로 정렬을 하기 위해서 heapq에 저장한다.

수업이 끝나는 강의실은 제거 - heapq.heappop(q)

새로운 강의실 생성 - 끝나는 시간 저장 - heapq.heappush(q,array[i][1])

<h2>코드</h2>

```python
import sys, heapq
input = sys.stdin.readline

N = int(input())
array = [list(map(int,input().split())) for _ in range(N)]
array.sort()

q = []
heapq.heappush(q,array[0][1])

for i in range(1,len(array)):
    # 수업이 끝나는 강의실은 제거 - heapq.heappop(q)
    # 새로운 강의실 생성 - 끝나는 시간 저장 - heapq.heappush(q,array[i][1])
    if q[0] <= array[i][0]:
        heapq.heappop(q)
    heapq.heappush(q,array[i][1])

# 현재 남아있는 강의실 수
print(len(q))
```