<h2>43165: 타겟넘버</h2>

https://programmers.co.kr/learn/courses/30/lessons/43165

<h2>설계</h2>
풀이: DFS

DFS를 돌며 numbers 배열의 수를 모두 사용하며
target값과 같을 경우에 결과 값을 증가시킨다.

<h2>코드</h2>

```python
def Solution(numbers,target):
    
    dfs(0,0,numbers,target)

    return result 

def dfs(idx,choosed,numbers,target):
    global result

    if idx == len(numbers):
        if choosed == target:
            result+=1
        
        return

    dfs(idx+1,choosed+numbers[idx],numbers,target)
    dfs(idx+1,choosed-numbers[idx],numbers,target)

result = 0
# numbers = [1, 1, 1, 1, 1]
# target = 3

numbers = [4, 1, 2, 1]	
target = 4

Solution(numbers,target)
print(result)

```