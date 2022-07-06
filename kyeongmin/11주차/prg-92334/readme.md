<h2>92334: 신고 결과 받기</h2>

https://school.programmers.co.kr/learn/courses/30/lessons/92334

<h2>설계</h2>

중복 제거를 위해서 set으로 처리한 후 신고 받은 횟수를 딕셔너리에 저장하여 풀이

<h2>코드</h2>

```python
def split_report(id_list,report):
    d = {x : 0 for x in id_list}
    
    for r in report:
        d[r.split()[1]] += 1
            
    return d

def go(d,k,report,id_list):
    result = [0] * len(id_list)

    for r in report:
        if k <= d[r.split()[1]]:
            result[id_list.index(r.split()[0])] += 1

    return result

def solution(id_list, report, k):
    report = set(report)

    d = split_report(id_list,report)
    
    answer = go(d,k,report,id_list)
    
    return answer

# print(solution(["muzi", "frodo", "apeach", "neo"],["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"],2))
print(solution(["con", "ryan"],["ryan con", "ryan con", "ryan con", "ryan con"],3))
```