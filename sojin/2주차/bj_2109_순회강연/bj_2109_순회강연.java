package ����;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_2109_��ȸ���� {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	public static void main(String[] args) throws Exception{
		int total=0; //�����ݾ�
		int maxday=Integer.MIN_VALUE;
		// N �Է¹ޱ�
		int N=Integer.parseInt(br.readLine());
		
		if(N==0) {
			System.out.println(0);
			System.exit(0);
		}
		
		Lecture[] lecture=new Lecture[N];
		//�Է� �ޱ�
		for(int i=0;i<N;i++) {
			tokens=new StringTokenizer(br.readLine());
			lecture[i]=new Lecture(Integer.parseInt(tokens.nextToken()),Integer.parseInt(tokens.nextToken()));
		}
		
		//lecture�� ����
		Arrays.sort(lecture);
		
		//�ִ� ���ϱ�
		for(int i=0;i<N;i++) {
			maxday=Math.max(maxday, lecture[i].day);
		}
		
		//�ִ񳯺��� �����ؼ� �˻��س�����
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
