package 프로그래머스;

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
