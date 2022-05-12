import sys
input = sys.stdin.readline

N,M = map(int,input().split())
array = [list(map(int,input().split())) for _ in range(M)]
result = int(1e9)
d = [[int(1e9)] * (N+1) for _ in range(N+1)]

def flow():
    for i in range(M):
        d[array[i][0]][array[i][1]] = 1
        d[array[i][1]][array[i][0]] = 1

    for k in range(1,N+1):
            d[k][k] = 0
            for i in range(1,N+1):
                for j in range(1,N+1):
                    d[i][j] = min(d[i][j],d[i][k]+d[k][j])

tp = []
def comb(start,idx,choosed):
    if idx == 2:
        result = 0

        for i in range(1,N+1):
            # 치킨집 둘 중에 하나 가까운 거리 구하기
            result += min(d[choosed[0]][i], d[choosed[1]][i])
        tp.append((result * 2,choosed[0],choosed[1]))
        return

    for i in range(start,N+1):
        choosed[idx] = i
        comb(i+1,idx+1,choosed)

flow()
comb(1,0,[0] * 2)
tp.sort()

print(tp[0][1],tp[0][2],tp[0][0])