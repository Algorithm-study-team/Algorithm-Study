# import sys
# input = sys.stdin.readline

# N,K = map(int, input().split())

# array = [[0,0]]
# dp = [[0] * (K+1) for _ in range(N+1)]

# for i in range(N):
#     array.append(list(map(int,input().split())))

# # 2차원 dp
# def knapscak():
#     for i in range(1,N+1):
#         w = array[i][0]
#         v = array[i][1]
#         for j in range(1,K+1): 
#             if j < w:
#                 dp[i][j] = dp[i-1][j]
#             else:
#                 dp[i][j] = max(dp[i-1][j], dp[i-1][j-w]+v)
                
# knapscak()
# print(dp[N][K])

# 1차원 dp
import sys
input = sys.stdin.readline

N,K = map(int, input().split())

array = []
dp = [0] * (K+1)

for i in range(N):
    array.append(list(map(int,input().split())))

def knapscak():
    for w,v in array:
        for i in range(K,w-1,-1):
            dp[i] = max(dp[i],dp[i-w]+v)
            
array.sort()
knapscak()
print(dp[K])