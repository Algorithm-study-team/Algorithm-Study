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