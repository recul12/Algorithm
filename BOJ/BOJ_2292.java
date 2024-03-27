package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2292 {
    /*
        육각형으로 이루어진 벌집이 있다.
        중앙의 방 1부터 시작하여 이웃하는 방에 돌아가면서 1씩 증가하는 번호르 주소로 매길 수 있다.
        숫자 N이 주어질 때, 벌집 중앙 1에서 N번 까지 최소 개수의 방을 지나서 갈 때 몇 개의 방을 지나가는지를 계산하자.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int cnt = 0;
        int idx = 0;
        while(N > 0){
            if(cnt == 0){
                N--;
            }else {
                N -= 6 * idx;
            }
            cnt++;
            idx++;
        }


        System.out.println(cnt);
    }
}
