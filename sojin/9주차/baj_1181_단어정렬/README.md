<h2>문제이름:bj 단어정렬(S5)  </h2>

https://www.acmicpc.net/problem/1181

<h2>설계</h2>

- 구현

  - 중복은 set에 넣고 다시 list에 넣어주면서 제거하기
  - list에 (0,1) 형태로 값을 두개 넣을 수 있다. 두개 넣은 후 sort()을 하면 list[0]을 기준으로 정렬 후 list[1]로도 정렬을 한다. 

<h2>코드</h2>



```python
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


```

