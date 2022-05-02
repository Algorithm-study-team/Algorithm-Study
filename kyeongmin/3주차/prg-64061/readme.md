<h2>64061: 2019 카카오 개발자 겨울 인턴십 - 크레인 인형뽑기 게임</h2>

https://programmers.co.kr/learn/courses/30/lessons/64061

<h2>설계</h2>
풀이: 스택

1. 인형 뽑기 안에 있는 인형 차례대로 뽑아서 스택에 쌓는다.
2. 스택의 peek인 가장 상단 값과 현재뽑은 인형이 같다면
3. 스택 pop을 진행하고 전에 넣었던 인형과 현재 넣을 인형의 값을 더해야 하므로 결과값을 2를 더해준다.

<h2>코드</h2>

```java
    import java.util.*;

    class Solution {
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

```