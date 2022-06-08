<h2>문제이름:prg 문자열내마음대로정렬하기(Lv1)  </h2>

https://programmers.co.kr/learn/courses/30/lessons/12915

<h2>설계</h2>

- 구현

  - 정렬하고싶은 문자를 앞에 붙여서 정렬 후 앞에 붙인 문자를 제거한 후 출력했다.
  - 다른분이 lambda로 푼 풀이 : sorted(sorted(strings),key=lambda x:x[n])

<h2>코드</h2>

- Map

```python

def solution(strings, n):
    answer = []
    ans = []
    for i in range(len(strings)):
        answer.append(strings[i][n]+strings[i])

    answer.sort()

    for anss in answer:
        ans.append(anss[1:])

    return ans


```

