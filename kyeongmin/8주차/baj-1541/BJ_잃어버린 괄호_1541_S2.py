import sys
input = sys.stdin.readline

array = input().split('-')
result = sum(map(int, array[0].split('+')))

for arr in array[1:]:
    result -= sum(map(int,arr.split('+')))

print(result)