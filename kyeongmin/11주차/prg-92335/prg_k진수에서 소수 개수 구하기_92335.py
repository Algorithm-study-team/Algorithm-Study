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