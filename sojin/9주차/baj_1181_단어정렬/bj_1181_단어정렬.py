N = int(input())
lst = []
for i in range(N):
    lst.append(input())
lst = list(set(lst))  # lst를 set으로 변경 후 중복 제거하고 다시 list로 만들기
lst2 = []
for i in lst:
    lst2.append((len(i), i))

lst2.sort()


for a, b in lst2:
    print(b)
