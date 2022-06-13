import sys
input = sys.stdin.readline

N = int(input())
mi = int(1e9)
ma = 0

def count(x):
    cnt = 0
    l = len(str(x))
    for _ in range(l):
        n = x%10
        
        if n % 2 == 1:
            cnt+=1
            
        x//=10
        
    return cnt

def dfs(x,cnt):
    global mi,ma
    # 수가 한 자리이면 더 이상 아무것도 하지 못하고 종료한다.
    if x < 10:
        mi,ma = min(mi,cnt),max(ma,cnt)
        return
    
    # 수가 두 자리이면 2개로 나눠서 합을 구하여 새로운 수로 생각한다.
    if x < 100:
        s = x//10+x%10
        dfs(s,cnt+count(s))
        return
    
    # 수가 세 자리 이상이면 임의의 위치에서 끊어서 3개의 수로 분할하고, 3개를 더한 값을 새로운 수로 생각한다.
    # 8 / 2 / 019 , 8 / 20 / 19 , 8 / 201 / 9 , 82/ 0 / 19 , 820/1/9
    for i in range(1,len(str(x))-1):
        for j in range(i+1,len(str(x))):
            a,b,c = str(x)[:i],str(x)[i:j],str(x)[j:]
            h = int(a)+int(b)+int(c)
            dfs(h,cnt+count(h))
            
dfs(N,count(N))
print(mi,ma)