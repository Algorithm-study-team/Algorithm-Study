<h2>1062: 가르침</h2>

https://www.acmicpc.net/problem/1062

<h2>설계</h2>
풀이: 완전탐색

'a','n','t','i','c'는 선택되어야 하므로

이 5개 알파벳을 제외하고 입력 받은 단어에서 K-5개 알파벳을 조합으로 선택한 후

선택할 수 있는 단어의 개수를 체크한다.

<h2>코드</h2>

```python
import sys
input = sys.stdin.readline

N,K = map(int,input().split())

if K < 5:
    print(0)
    sys.exit()
elif K == 26:
    print(N)
    sys.exit()

array = [set(input().strip()) for _ in range(N)]
a = [0] * 26

for t in ('a','n','t','i','c'):
    a[ord(t)-ord('a')] = 1
    
result = 0

def go(s,idx):
    global result

    if idx == K-5:
        cnt = 0
        for arr in array:
            c = True
            for aa in arr:
                if not a[ord(aa) - ord('a')]:
                    c = False
                    break
            if c:
                cnt+=1
    
        result = max(result,cnt)
        return
    
    for i in range(s,26):
        if not a[i]:
            a[i] = 1
            go(i+1,idx+1)
            a[i] = 0
    
go(0,0)
print(result)
```