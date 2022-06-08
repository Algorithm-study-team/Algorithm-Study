<h2>10825: 국영수</h2>

https://www.acmicpc.net/problem/10825

<h2>설계</h2>
풀이: 정렬

result = sorted(array, key = lambda x : (-int(x[1]),int(x[2]),-int(x[3]),x[0]))

1. 국어 점수가 감소하는 순서로 (-int(x[1]) -를 붙이면 내림차순

2. 국어 점수가 같으면 영어 점수가 증가하는 순서로 (int(x[2])) 오름차순

3. 국어 점수와 영어 점수가 같으면 수학 점수가 감소하는 순서로 (-int(x[3])) 내림차순

4. 모든 점수가 같으면 이름이 사전 순으로 증가하는 순서로 (단, 아스키 코드에서 대문자는 소문자보다 작으므로 사전순으로 앞에 온다.) (x[0]) 사전 순


<h2>코드</h2>

```python
import sys
input = sys.stdin.readline

N = int(input())
array = [list(map(str,input().split())) for _ in range(N)]

result = sorted(array, key = lambda x : (-int(x[1]),int(x[2]),-int(x[3]),x[0]))

for i in result:
    print(*i[:1])
```