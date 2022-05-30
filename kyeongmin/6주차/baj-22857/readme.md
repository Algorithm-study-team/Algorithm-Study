<h2>22875: 가장 긴 짝수 연속한 부분 수열(small)</h2>

https://www.acmicpc.net/problem/22857

<h2>설계</h2>
풀이: DP

인덱스 0번부터 탐색하여 홀수일 경우에 홀수 체크 변수를 증가시키고
끝을 나타내는 변수 end를 증가시키며 홀수의 개수를 체크한다.

<h2>코드</h2>

```python
import sys
input = sys.stdin.readline

N,K = map(int,input().split())
array = list(map(int,input().split()))
result = 0
end = 0
cnt = 0

for start in range(N):
    while cnt <= K and end < N and result <= N-start:
        if array[end] % 2:  
            cnt+=1
        end +=1

    result = max(result,end-start-cnt)     
    
    # 시작이 홀수였으면 하나 빼기
    if array[start] % 2:
        cnt-=1

print(result)
```