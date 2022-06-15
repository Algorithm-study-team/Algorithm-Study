n = int(input())
lst = []
for _ in range(n):
    a, b = input().split()
    a = int(a)
    lst.append((a, b))

sorted_lst = sorted(lst, key=lambda x: x[0])


for a,b in sorted_lst:
    print(a,b)
# n_members = int(input())

# member_list = []
# for _ in range(n_members):
#     (x, y) = input().split()
#     member_list.append((int(x), y))


# sorted_list = sorted(member_list, key=lambda x: x[0])

# for i in sorted_list:
#     print(i[0], i[1])
