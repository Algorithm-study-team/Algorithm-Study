<h2>문제이름:prg 체육복(Lv1)  </h2>

https://programmers.co.kr/learn/courses/30/lessons/42862

<h2>설계</h2>

- 구현

  - set을 사용 
  - 도난당한 학생이 중복될 수 있으니 set(lost)을 하고, 여벌 체육복 가져온 학생과 겹치면 빌려주지 못하므로 reserve에서도 중복 제거
  
<h2>코드</h2>

```python

def solution(n, lost, reserve):
 # n:학생수 lost: 도난당한 학생 번호 reserve:여벌 체육복 가져온 학생 번호
 # python set은 remove,add,discard가능
    # 체육복 있는 사람이 도난당한 경우를 위한 조건
    real_lost = set(lost)-set(reserve)
    real_reserve = set(reserve)-set(lost)

    for i in real_reserve:
        if i-1 in real_lost:
            real_lost.remove(i-1)
        elif i+1 in real_lost:
            real_lost.remove(i+1)

    return n-len(real_lost)

```

