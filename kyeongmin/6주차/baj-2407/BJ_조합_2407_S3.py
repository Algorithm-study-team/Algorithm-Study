import sys
input = sys.stdin.readline

N,M = map(int,input().split())
cnt = 0
dp = [[0] * (101) for _ in range(101)]

for i in range(1,101):
    dp[i][i] = 1
    dp[i][0] = 1

for i in range(1,101):
    for j in range(1,i):
        dp[i][j] = dp[i-1][j-1]+dp[i-1][j]
print(dp[N][M])