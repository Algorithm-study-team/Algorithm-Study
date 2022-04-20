import java.util.*;

public class BJ_NQUEEN_9663_G5 {
    static int N,cnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        dfs(0,new ArrayList<>());
        System.out.println(cnt);
    }

    private static void dfs(int idx, List<Integer> list){
        if(idx == N){
            cnt++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if(check(i,list)){
                list.add(i);
                dfs(idx+1,list);
                list.remove(list.size()-1);
            }
        }
    }

    private static boolean check(int c, List<Integer> list){
        int r = list.size();

        for (int i = 0; i < r; i++) {
            if(list.get(i) == c || Math.abs(c - list.get(i)) == r-i){
                return false;
            }
        }

        return true;
    }
}
