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

import sys
from itertools import combinations
input = sys.stdin.readline

N,K = map(int, input().split())

if K < 5:
    print(0)
    sys.exit()
elif K == 26:
    print(N)
    sys.exit()

array = []

for _ in range(N):
    array.append(set(input().strip()).difference('a', 'c', 'i', 't', 'n'))

# bin_dict : a/c/i/t/n을 제외한 알파벳 각각에 임의의 고유 번호를 부여한 딕셔너리
bin_dict = {'b': 20, 'd': 19, 'e': 18, 'f': 17, 'g': 16, 'h': 15, 'j': 14,
            'k': 13, 'l': 12, 'm': 11, 'o': 10, 'p': 9, 'q': 8, 'r': 7,
            's': 6, 'u': 5, 'v': 4, 'w': 3, 'x': 2, 'y': 1, 'z': 0}


# 알파벳 배열을 2진수로 바꾸어주는 함수
def change(word):
    answer = 0b0
    for x in word:
        answer |= 1 << bin_dict[x]

    return answer

l = [change(x) for x in array]
result = 0

a = [2 ** i for i in range(21)]

for comb in combinations(a, K - 5):
    s = sum(comb)
    cnt = 0
    for n in l:
        # 현재 순회 중인 단어를 만들 수 있다면
        if n & s == n:
            cnt += 1

    result = max(result, cnt)

print(result)