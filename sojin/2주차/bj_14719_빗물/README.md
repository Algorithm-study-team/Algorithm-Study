<h2>문제이름:bj 빗물(G5)  </h2>

https://www.acmicpc.net/problem/14719

<h2>설계</h2>

- 구현

  - 물이 쌓이는 칸 수를 찾는 문제이다.
  - 모든 지점을 탐색하면서 내 기준에서 왼쪽에서 가장 높은 부분과 오른쪽에서 가장 높은 부분을 찾고, 이 둘중에서 더 작은 부분을 높이로 삼는다면 내 위치에서 물이 고이는 구간을 구할 수 있다.
  - 이때 제일 왼쪽 부분과 제일 오른쪽 부분은 확인할 필요가 없으니까 1부터 N-1까지 for문을 돈다.


<h2>코드</h2>

- Map

```java

package 백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_14719_빗물 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int R,C;
	static int[]arr;
	public static void main(String[] args) throws Exception{
		tokens=new StringTokenizer(br.readLine());
		R=Integer.parseInt(tokens.nextToken());
		C=Integer.parseInt(tokens.nextToken());
		arr=new int[C];
		
		tokens=new StringTokenizer(br.readLine());
		
		for(int i=0;i<C;i++) {
			arr[i]=Integer.parseInt(tokens.nextToken());
		}

		
		//높이는 작은것 기준이다.
		//왼쪽에서 가장 높은것, 오른쪽에서 가장 높은것 구하고 그 인덱스중에서 더 작은부분을 높이로 친다. 
		int cnt=0;
		
		//가운데 기준으로 왼쪽 큰거 오른쪽 큰거 구해서 그 차이 빼서 더해주기
		for(int i=1;i<C-1;i++) {
			
			int right=0;
			int left=0;
			//내 기준에서 왼쪽으로 큰것
			for(int j=0;j<i;j++) {
				if(left<arr[j]) {
					left=arr[j];
				}
			}
			
			//내 기준에서 오른쪽으로 큰것
			for(int k=i;k<C;k++) {
				if(right<arr[k]) {
					right=arr[k];
				}
			}
			
			// 이제 오른쪽/왼쪽 차이중에서 더 작은거 구하기
			int min=Math.min(left, right);
			
			//만약 그 최소보다 내가 작아야지 빗물 구할 수 있다.
			if(min>arr[i]) {
				cnt+=min-arr[i];
			}
			
		}
		System.out.println(cnt);
	}

}

```

