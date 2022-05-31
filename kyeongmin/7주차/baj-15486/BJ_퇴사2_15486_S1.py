import sys
input = sys.stdin.readline

N = int(input())
a = [list(map(int,input().split())) for _ in range(N)]
dp = [0] * (N+1)
temp = 0

for i in range(N):
    temp = max(temp,dp[i])

    if a[i][0]+i <= N:
        dp[a[i][0]+i] = max(a[i][1]+temp,dp[a[i][0]+i])

print(max(dp))