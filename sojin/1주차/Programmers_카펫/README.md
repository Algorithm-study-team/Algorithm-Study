<h2>문제이름:programmers 카펫(Lv2)  </h2>

https://programmers.co.kr/learn/courses/30/lessons/42842

<h2>설계</h2>

- 완전탐색 : 규칙을 찾으려고 했고, (w+h)*2+4==brown 이라는 점을 이용하여 해결 

<h2>코드</h2>

- 완전탐색

```java
package 프로그래머스;

class Solution {
    public int[] solution(int brown, int yellow) {
      int[] answer = new int[2];
      int i=1;
		while(true) {
			//i가 N보다 더 커지면 끝
			if(i>yellow) {
				break;
			}
			int w=0;
			int h=0;
			//만약 i==1이면? 
			if(i==1) {
				 w=yellow;
				 h=i;
			}else{
				if(yellow%i==0) {
					w=yellow/i;
					h=i;
				}
			}
			if(w>=h) {
				if((w+h)*2+4==brown) {
                    w=w+2;
                    h=h+2;
					answer[0]=w;
                    answer[1]=h;
					break;
				}
			}
			i++;
		}
        
        return answer;
    }
}
```

