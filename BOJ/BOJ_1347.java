package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1347 {
    static int dx[]={0,1,0,-1};
    static int dy[]={-1,0,1,0};
    public static void main(String[] args) throws IOException {
        /*
            미로 만들기
            직사각형 격자 모양의 미로가 있다.
            미로의 각 칸은 이동가능하거나, 벽을 포함한다.
            모든 행과 열에는 적어도 하나의 이동할 수 있는 칸이 있다.
            미로 안의 한 칸에서 남쪽을 보며 서있다고 가정하자.
            미로에서 모든 행과 열의 이동할 수 있는 칸을 걸어다니고 기록한다.
            F는 앞으로 한 칸, L,R 은 왼쪽 또는 오른쪽으로 전환한 것이다.
            미로 지도를 출력하라.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 적은 내용의 길이
        int N = Integer.parseInt(br.readLine());
        // 적은 내용
        String s = br.readLine();

        /*
            내용의 길이가 0보다 크고 50보다 작다는 조건이 있다.
            지도의 시작을 가운데로 한다면 100의 지도 크기를 만들어서 움직이도록 하자.
         */
        char map[][]=new char[101][101];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = '#';
            }
        }
        // 시작 지점
        int x=50,y=50;
        // 남쪽을 바라보는 방향
        int dir=1;
        // 움직였던 우측 위 끝 좌표와 좌측 아래 끝 좌표만을 출력하기 위한 좌표
        int leftX = 50, leftY = 50;
        int rightX= 50, rightY = 50;
        // 시작지점 . 문자로 변경
        map[x][y] = '.';

        for(char c : s.toCharArray()){
            // 오른쪽으로 방향 회전
            if(c == 'R'){
                // 좌,하,우,상 순서로 우측으로 움직이면 남쪽을 바라보는 상태에선 좌로 움직이면 된다.
                if(dir == 0) dir = 3;
                else dir--;
            }
            // 왼쪽으로 방향 회전
            else if(c == 'L'){
                if(dir == 3) dir=0;
                else dir++;
            }
            else{
                x=x+dx[dir];
                y=y+dy[dir];
                map[x][y] = '.';
                leftX = Math.min(leftX, x);
                leftY = Math.min(leftY, y);
                rightX = Math.max(rightX, x);
                rightY = Math.max(rightY, y);
            }
        }

        for (int i = leftX; i <= rightX; i++) {
            for (int j = leftY; j <= rightY; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
