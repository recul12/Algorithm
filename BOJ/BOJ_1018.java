package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
    지민이는 집에서 MN개의 단위 정사각형으로 나누어져 있는 M×N 크기의 보드를 찾았다.
    어떤 정사각형은 검은색으로 칠해져 있고, 나머지는 흰색으로 칠해져 있다.
    지민이는 이 보드를 잘라서 8×8 크기의 체스판으로 만들려고 한다.

    체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다.
    각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다.
    따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다.
    하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.

    보드가 체스판처럼 칠해져 있다는 보장이 없어서,
    지민이는 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다.
    당연히 8*8 크기는 아무데서나 골라도 된다
    지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하라.
 */
public class BOJ_1018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char board[][] = new char[N][M];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = tmp.charAt(j);
            }
        }
        /*
            중요한 것은 어떤 색으로 보드가 시작할지, 현재 보드칸의 색깔이 전과 다른지를 확인하는 것
            나올 수 있는 모든 보드들 중에 최소값을 구해야한다.
            8칸 이상인 보드가 나올 수 있도록 N과 M쪽의 시작값은 최소 N-8, M-8이 되도록 한다.
            W시작, B시작으로 두 개의 경우의 수 중 최소값을 구하고, 원래 최소값과 비교하여 결과를 도출한다.

         */
        int min = Integer.MAX_VALUE;

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                min = Math.min(min, Math.min(repaint(i, j, 'W', board), repaint(i, j, 'B', board)));
            }
        }

        System.out.println(min);
    }

    public static int repaint(int startX, int startY, char startColor, char[][] board){
        int count = 0;
        char color = startColor;

        for (int i = startX; i < startX+8; i++) {
            for (int j = startY; j < startY+8; j++) {
                // 현재 위치가 색깔이 달라져야 한다면 카운트
                if(board[i][j] != color) count++;

                // 다음 칸은 현재 칸과 다른 색깔이 되어야한다.
                if(color == 'W') color = 'B';
                else color = 'W';
            }
            // 다음 행이 시작할 때는 현재 행의 마지막 색깔과 다른 색깔이 되어야한다.
            if(color == 'W') color = 'B';
            else color = 'W';
        }

        return count;
    }
}
