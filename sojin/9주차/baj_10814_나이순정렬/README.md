<h2>문제이름:bj 나이순정렬(S5)  </h2>

https://www.acmicpc.net/problem/10814

<h2>설계</h2>

- 구현

  - lambda를 사용해서 정렬
  - 리스트에는 (a,b)형식으로 넣어서 x[0]번(나이)을 기준으로 정렬한다.
<h2>코드</h2>



```python

n = int(input())
lst = []
for _ in range(n):
    a, b = input().split()
    a = int(a)
    lst.append((a, b))

sorted_lst = sorted(lst, key=lambda x: x[0])


for a,b in sorted_lst:
    print(a,b)


```

