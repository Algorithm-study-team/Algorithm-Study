<h2>문제이름:prg 완주하지못한선수(Lv1)  </h2>

https://programmers.co.kr/learn/courses/30/lessons/42576

<h2>설계</h2>

- 구현

  - zip을 사용했는데 zip은 같은 인덱스를 갖는 것 끼리 비교
  - ex) part[1]=com[1], part[2]=com[2]
  - 정렬 후 같은 인덱스를 가진 것 끼리 비교하고 같지 않다면 체일끝에 있는 것 반환	

<h2>코드</h2>

```python

package 백준;
def solution(participant, completion):
    participant.sort()
    completion.sort()
    # zip은 인덱스 같은애들끼리 비교
    for part, com in zip(participant, completion):
        if part != com:
            return part

    return participant[len(participant)-1]  # participant[-1]이라고 해도됨(제일끝)


```

