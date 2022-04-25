<h2>문제이름:bj 용액(G5)  </h2>

https://www.acmicpc.net/problem/2467

<h2>설계</h2>

- 투포인터

  - 두 용액을 비교해서 0보다 가까운 것을 찾는 문제이다.
  -  음수와 양수를 포함하여 오름차순 정렬하여 비교를 하는 것 이기 때문에 투포인터를 사용해서 start(0)와 end(N-1) 으로 두고, 음수면 start지점을 ++, 양수면 end 지점을 -- 해서 비교를 해야 겠다고 생각했다.  
  - 그리고 start>end이면 비교가 다 되었다고 생각해서 while문을 벗어나게 했다.


<h2>코드</h2>

- Map

```java
package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_2467_용액 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int[]arr;
	static long ans;
	public static void main(String[] args) throws Exception{
		
		int N=Integer.parseInt(br.readLine());
		int[] num=new int[2];
		arr=new int[N];
		tokens=new StringTokenizer(br.readLine());
		
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(tokens.nextToken());
		}
		
		//arr이 오름차순으로 되어있으므로, -> <-을 비교해서 음수면 -> 양수면 <-
		ans=Integer.MAX_VALUE;
		int start=0; //시작지점은 0번
		int end=N-1; //끝지점은 N-1번 
		
		//start가 end와 같거나 커지면 stop
		while(end>start) {
			int c1=arr[start];
			int c2=arr[end];
			int temp=c1+c2;
			//만약 이전에 저장되어있던 것 보다 작으면 저장해주기
			if(isClosed(temp)) {
				num[0]=c1;
				num[1]=c2;
			}
			if(temp<0) {
				start++;
			}else if(temp>0) {
				end--;
			}//만약 0을 만났다면 더이상 갈 필요 x
			else if(temp==0) {
				break;
			}

		}
		
		Arrays.sort(num);
		System.out.println(num[0]+" "+num[1]);
	}
	static public boolean isClosed(int cnt) {
		//만약 0에 더 가깝다면?
		if(Math.abs(ans)>Math.abs(0-cnt)) {
			ans=cnt;
			return true;
		}
		return false;
	}

}

```

