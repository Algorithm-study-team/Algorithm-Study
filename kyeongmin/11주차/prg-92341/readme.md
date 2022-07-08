<h2>92341: 주차 요금 계산</h2>

https://school.programmers.co.kr/learn/courses/30/lessons/92341

<h2>설계</h2>
입력 받은 주차 정보를 딕셔너리에 저장 후 출차 내역이 있는 경우와 없는 경우에 따라서 요금을 계산한다.

<h2>코드</h2>

```python
import math

def date(x):
    a,b = x.split(":")
    return int(a) * 60 + int(b)

def change(records):
    d = dict()
    
    for r in records:
        a,b,c = r.split()
        
        if d.get(b):
            d[b].append((date(a),c))
        else:
            d[b] = [(date(a),c)]
    
    return d

def go(fees,x):
    a,b,c,d = fees
    result = [0] * len(x)

    for i,(k,v) in enumerate(x):
        temp = 0
        time = 0
        check = True
        
        for t in v:
            if t[1] == "IN":
                temp = t[0]
                check = False
            else:
                time += t[0]-temp
                check = True
        
        if check:
            if a < time:
                result[i] = b + (math.ceil((time-a)/c)) * d
            else:
                result[i] = b
        else:
            r = (1439-temp)+time
            
            if a < r:
                result[i] = b + (math.ceil((r - a)/c)) * d
            else:
                result[i] = b
        
    return result

def solution(fees,records):
    answer = []
    
    d = change(records)
    answer = go(fees,sorted(d.items()))
    return answer

# print(solution([180, 5000, 10, 600],["05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"]))
print(solution([1, 461, 1, 10],["00:00 1234 IN"]))
```