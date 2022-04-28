import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int count = 0;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for(int i=0; i < lost.length; i++) {
            for(int j=0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    count++;
                    break;
                }
            }
        }
        for (int i=0; i < lost.length; i++) {
            for (int j=0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]+1 || lost[i] == reserve[j]-1) {
                    count++;
                    reserve[j] = -1;
                    break;

                }
            }
        }
        return (n - lost.length) + count;
    }
}