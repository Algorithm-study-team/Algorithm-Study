import sys
input = sys.stdin.readline

N,M = map(int,input().split())
array = [list(map(int,input().split())) for _ in range(N)]
dp = [[0] * M for _ in range(N)]
dp2 = [[0] * M for _ in range(N)]

# 상승 비행
dp[N-1][0] = array[N-1][0]
for i in range(N-2,-1,-1):
    dp[i][0] = array[i][0]+dp[i+1][0]

for i in range(1,M):
    dp[N-1][i] = array[N-1][i]+dp[N-1][i-1]
    
for i in range(N-2,-1,-1):
    for j in range(1,M):
        dp[i][j] = array[i][j]+max(dp[i+1][j],dp[i][j-1])

# 하강 비행
dp2[N-1][M-1] = array[N-1][M-1]
for i in range(N-2,-1,-1):
    dp2[i][M-1] = array[i][M-1]+dp2[i+1][M-1]

for i in range(M-2,-1,-1):
    dp2[N-1][i] = array[N-1][i]+dp2[N-1][i+1]

for i in range(N-2,-1,-1):
    for j in range(M-2,-1,-1):
        dp2[i][j] = array[i][j]+max(dp2[i+1][j],dp2[i][j+1])

result = dp[0][0]+dp2[0][0]
for i in range(N):
    for j in range(M):
        result = max(result,dp[i][j]+dp2[i][j])

print(result)