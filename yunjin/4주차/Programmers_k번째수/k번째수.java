import java.util.Arrays;

class Solution {
   public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] tempArray = new int[commands[i][1] - commands[i][0] + 1];

            int a = 0;
            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                tempArray[a] = array[j];
                a++;
            }
            Arrays.sort(tempArray);
            answer[i] = tempArray[commands[i][2] - 1];
        }
        return answer;
    }
}