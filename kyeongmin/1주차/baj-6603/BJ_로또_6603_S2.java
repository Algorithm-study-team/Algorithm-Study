import java.io.*;
import java.util.*;

public class BJ_로또_6603_S2 {
    static int T;
    static int[] array;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        while(true){
            st = new StringTokenizer(br.readLine());
            T = Integer.parseInt(st.nextToken());
            if(T == 0) break;
            array = new int[T];

            for (int i = 0; i < T; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }

            go(0,0,new int[6],new boolean[6]);
            System.out.println();
        }


    }

    private static void go(int start, int idx, int[] choosed, boolean[] visited){
        if(idx == choosed.length){
            for (int i = 0; i < choosed.length; i++) {
                System.out.print(choosed[i]+" ");
            }

            System.out.println();
            return;
        }

        for (int i = start; i < T; i++) {
                choosed[idx] = array[i];
                go(i+1,idx+1,choosed,visited);
        }
    }
}
