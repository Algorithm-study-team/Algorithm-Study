import sys
input = sys.stdin.readline

N = int(input())
array = [list(map(str,input().split())) for _ in range(N)]
d = dict()

for x,y in array:
    if y == "leave":
        d.pop(x)
    else:
        d[x] = y
d = sorted(d.items(),reverse = True)

for x,y in d:
    print(x)