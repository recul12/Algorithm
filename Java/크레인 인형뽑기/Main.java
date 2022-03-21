package Algorithm;

/*
인형뽑기 크레인
 */


import java.util.*;

public class Main {
    public int solution(int [][] board, int [] moves){
        int answer=0;
        Stack<Integer> stack=new Stack<>();

        for(int i: moves){
            for(int j=1;j<board.length; j++) {
                if (board[j][i] != 0) {
                    int tmp=board[j][i];
                    board[j][i]=0;
                    if(!stack.isEmpty()&&stack.peek()==tmp) {
                        stack.pop();
                        answer+=2;
                    }
                    else
                        stack.push(tmp);
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T=new Main();
        Scanner sc=new Scanner(System.in);

        int N= sc.nextInt();
        int [][] board=new int[N+1][N+1];
        for(int i=1; i<N+1; i++){
            for(int j=1; j<N+1; j++){
                board[i][j]=sc.nextInt();
            }
        }
        int M= sc.nextInt();
        int [] moves = new int[M];
        for(int i=0; i<M; i++){
            moves[i]=sc.nextInt();
        }

        System.out.print(T.solution(board, moves));
    }
}
