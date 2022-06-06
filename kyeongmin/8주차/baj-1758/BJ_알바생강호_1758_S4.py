import sys
input = sys.stdin.readline

N = int(input())
array = [int(input()) for _ in range(N)]
array.sort(reverse = True)
result = 0

for i in range(N):
    if 0 < array[i]-i:
        result += array[i]-i

print(result)