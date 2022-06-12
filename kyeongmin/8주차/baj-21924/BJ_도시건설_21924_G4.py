import sys
input = sys.stdin.readline

N,M = map(int,input().split())
array = []
p = [0] * (N+1)
cost = 0
hap = 0

# 부모를 자기 자신으로 초기화
for i in range(1,N+1):
    p[i] = i

for i in range(1,M+1):
    a,b,c = map(int,input().split())
    array.append((c,a,b))
    hap+=c
    
# 간선들을 비용이 낮은 순으로
array.sort()

# 루트 노드가 아니라면 루트 노드를 찾을때까지 재귀 호출
def find(x):
    if p[x] != x:
        p[x] = find(p[x])
    return p[x]

# 두 원소가 속한 집합 합치기
def union(a,b):
    a = find(a)
    b = find(b)
    
    if a < b:
        p[b] = a
    else:
        p[a] = b

count = 0
for c,a,b in array:
    # 사이클이 발생하지 않은 경우에만 집합에 포함
    if find(a) != find(b):
        union(a,b)
        cost += c
        count += 1

if count == N-1:
    print(hap-cost)
else:
    print(-1)