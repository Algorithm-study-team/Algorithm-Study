def solution(strings, n):
    answer = []
    ans = []
    for i in range(len(strings)):
        answer.append(strings[i][n]+strings[i])

    answer.sort()

    for anss in answer:
        ans.append(anss[1:])

    return ans
