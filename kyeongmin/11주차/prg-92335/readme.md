<h2>92335: k진수에서 소수 개수 구하기</h2>

https://school.programmers.co.kr/learn/courses/30/lessons/92335

<h2>설계</h2>
입력 받은 n을 k진법으로 변경 후 "0"을 기준으로 나눈다

저장된 배열의 수들이 소수인지 해당 수의 제곱근까지만 확인한다.

<h2>코드</h2>

```python
import math

def change(n,k):
    s = ""
    while 0 < n:
        s+=str(n%k)
        n//=k
    return ''.join(reversed(s))

def st(s):
    return s.split("0")

def check(s):
    cnt = 0
    for t in s:
        c = True
        if len(t) == 0 or int(t) < 2: continue
        for j in range(2,int(math.sqrt(int(t)))+1):
            if int(t)%j == 0:
                c = False
                break
        if c:
            cnt +=1
    return cnt
        
def solution(n, k):
    s = ""
    if k != 10:
        s = st(change(n,k))
    else:
        s = st(str(n))
        
    return check(s)

print(solution(437674,3))
# print(solution(110011,10))
```