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
