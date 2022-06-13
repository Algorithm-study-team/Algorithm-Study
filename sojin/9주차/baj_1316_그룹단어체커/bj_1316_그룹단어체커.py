# 26개 배열에 0넣기


n = int(input())
cnt = n
for i in range(n):
    array = [0 for i in range(26)]
    str = input()

    for j in range(len(str)):
        # print(ord(str[j])-97)
        if array[ord(str[j])-97] == 0 or str[j-1] == str[j]:
            array[ord(str[j])-97] += 1
        else:
            cnt -= 1
            break

print(cnt)
