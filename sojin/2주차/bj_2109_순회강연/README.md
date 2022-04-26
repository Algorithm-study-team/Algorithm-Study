<h2>문제이름:bj 순회 강연(G3)  </h2>

https://www.acmicpc.net/problem/2109

<h2>설계</h2>

- 그리기
  - 가장 많은 돈을 벌 수 있는 것이니까 그리디 라고 생각했다.
  - d와 p를 받는데, d는 일자 안에 강연을 해줬으면 하는 날이고 p는 강연료이다.
  - 처음에는 그냥 일차로 오름차순 하고 일자가 같으면 돈으로 내림차순해서 구해보려고 했지만, 생각처럼 잘 되지 않아 방법을 바꾸었다.
  - 여기서 가장 중요한 것은 "돈을 많이 번다" 이다. 그렇기 때문에 큰 돈이면 무조건 가는 것이 이득이기 때문에 돈으로 내림차순을 하고, 돈이 같다면 일자로 내림차순을 했다. (같은 돈이라면 날짜가 넉넉한 것이 좋기 때문에) -> class의 compareTo 사용
  - 날짜의 최댓값으로 방문 체크를 하는 boolean형 배열을 초기화 해준다.
  - 배열을 정렬해주고 0부터 N까지 돌면, 큰돈 -> 작은돈 순으로 들어있다. 그래서 최대한 큰 돈은 무조건 사수해야 하기 때문에 for문을 돌려 일자를 줄여나가면서 방문하지 않은 일자를 찾고, 비어있다면 true로 변경 후 돈을 더해준다.  
  - 다 풀고 N이 0일때 체크를 안해줘서 runtime 에러가 났다.

<h2>코드</h2>

- 그리기

```java
package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_2109_순회강연 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	public static void main(String[] args) throws Exception{
		int total=0; //최종금액
		int maxday=Integer.MIN_VALUE;
		// N 입력받기
		int N=Integer.parseInt(br.readLine());
		
		if(N==0) {
			System.out.println(0);
			System.exit(0);
		}
		
		Lecture[] lecture=new Lecture[N];
		//입력 받기
		for(int i=0;i<N;i++) {
			tokens=new StringTokenizer(br.readLine());
			lecture[i]=new Lecture(Integer.parseInt(tokens.nextToken()),Integer.parseInt(tokens.nextToken()));
		}
		
		//lecture을 정렬
		Arrays.sort(lecture);
		
		//최댓날 구하기
		for(int i=0;i<N;i++) {
			maxday=Math.max(maxday, lecture[i].day);
		}
		
		//최댓날부터 시작해서 검사해나가기
		boolean[]days=new boolean[maxday+1]; 
		
		for(int i=0;i<N;i++) {
			for(int j=lecture[i].day;j>0;j--) {
				if(!days[j]) {
					total+=lecture[i].money;
					days[j]=true;
					break;
				}
			}
		}
		
		System.out.println(total);
		
	}
	private static class Lecture implements Comparable<Lecture>{
		int money;
		int day;
		
		public Lecture(int money,int day){
			this.money=money;
			this.day=day;
		}
		
		@Override
		public int compareTo(Lecture o) {
			if(o.money==this.money) {
				return o.day-this.day;
			}else {
				return o.money-this.money;
			}
		}
		
	}

}

```

