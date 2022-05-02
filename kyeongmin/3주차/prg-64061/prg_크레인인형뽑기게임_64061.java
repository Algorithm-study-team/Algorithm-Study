package programmers;

import java.util.*;

class prg_크레인인형뽑기게임_64061 {
    static Stack<Integer> sk = new Stack<>();
    static int result;

    public int solution(int[][] board, int[] moves) {

        go(board, moves);

        return result;
    }

    private static void go(int[][] board, int[] moves) {
        for(int i=0; i<moves.length; i++){
            int m = moves[i];
            move(-1,m-1,board);
        }
    }

    private static void move(int x, int y, int[][] board){
        int nx = x+1;
        int ny = y;

        if(0<=nx && nx<board.length && 0<=ny && ny<board.length){
            if(board[nx][ny] != 0){
                if(!sk.isEmpty() && (sk.peek() == board[nx][ny])){
                    sk.pop();
                    result+=2;
                }else{
                    sk.push(board[nx][ny]);
                }
                board[nx][ny] = 0;

                return;

            }else{
                move(nx,ny,board);
            }
        }

    }
}
