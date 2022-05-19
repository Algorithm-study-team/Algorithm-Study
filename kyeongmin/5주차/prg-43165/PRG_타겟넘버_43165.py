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