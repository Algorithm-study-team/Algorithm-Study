<h2>문제이름:백준 동전0(S3)  </h2>

https://www.acmicpc.net/problem/11047

<h2>설계</h2>

- 그리기
  - 최대의 가치가 되야하기 때문에 동전이 큰 것부터 사용할 수 있는지 보고 값에서 빼준다. 
  
    

<h2>코드</h2>

```java
package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static int N,K;
	static int[]coin;
	public static void main(String[] args) throws IOException {
		tokens=new StringTokenizer(br.readLine());
		N=Integer.parseInt(tokens.nextToken());
		K=Integer.parseInt(tokens.nextToken());
		coin=new int[N];
		
		for(int i=0;i<N;i++) {
			coin[i]=Integer.parseInt(br.readLine());
		} //동전 입력받기
		
		int cnt=0;
		int T=N-1;
		while(true) {
			if(K==0) {
				break;
			}
			for(int i=T;i>=0;i--) {
				if(coin[i]<=K) {
					//찾으면
					K-=coin[i];
					T=i;
					cnt++;
					break;
				}
			}
		}
		System.out.println(cnt);

	}

}

```

