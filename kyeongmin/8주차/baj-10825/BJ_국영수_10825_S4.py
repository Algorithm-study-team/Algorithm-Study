import sys
input = sys.stdin.readline

N = int(input())
array = [list(map(str,input().split())) for _ in range(N)]

result = sorted(array, key = lambda x : (-int(x[1]),int(x[2]),-int(x[3]),x[0]))

for i in result:
    print(*i[:1])