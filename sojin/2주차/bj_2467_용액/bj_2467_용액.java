package ���α׷��ӽ�;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_2467_��� {
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
		
		//arr�� ������������ �Ǿ������Ƿ�, -> <-�� ���ؼ� ������ -> ����� <-
		ans=Integer.MAX_VALUE;
		int start=0; //���������� 0��
		int end=N-1; //�������� N-1�� 
		
		//start�� end�� ���ų� Ŀ���� stop
		while(end>start) {
			int c1=arr[start];
			int c2=arr[end];
			int temp=c1+c2;
			//���� ������ ����Ǿ��ִ� �� ���� ������ �������ֱ�
			if(isClosed(temp)) {
				num[0]=c1;
				num[1]=c2;
			}
			if(temp<0) {
				start++;
			}else if(temp>0) {
				end--;
			}//���� 0�� �����ٸ� ���̻� �� �ʿ� x
			else if(temp==0) {
				break;
			}

		}
		
		Arrays.sort(num);
		System.out.println(num[0]+" "+num[1]);
	}
	static public boolean isClosed(int cnt) {
		//���� 0�� �� �����ٸ�?
		if(Math.abs(ans)>Math.abs(0-cnt)) {
			ans=cnt;
			return true;
		}
		return false;
	}

}
