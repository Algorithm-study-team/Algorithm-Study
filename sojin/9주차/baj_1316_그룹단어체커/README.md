<h2>문제이름:bj 그룹단어체커 (S5)  </h2>

https://www.acmicpc.net/problem/1316

<h2>설계</h2>

- 구현

  - ord를 이용해서 유니코드 숫자로 변경후 a인 97을 빼준다.
  - 한번도 입력 x (0) 이거나 이전에 나온 문자열과 같으면 +1해주고
  - 그게 아니라면 미리 받아두었던 cnt에서 1을 빼고 내부 for문을 멈춘다.

<h2>코드</h2>

- Map

```python

n = int(input())
cnt = n
for i in range(n):
    # 배열에 0넣기
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


```

