package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1931 {
    /*
        회의실 1개에서 N개의 회의를 진행, 가장 많은 회의를 진행할 수 있게 하고 싶다.
        시작과 끝 시간이 주어지고, 회의가 겹치면 안된다. 회의는 중단되지 않고 끝나자마자 다른 회의가 시작될 수 있다.
        회의는 시작과 끝 시간이 같을 수도 있다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int meeting[][] = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meeting[i][0]=Integer.parseInt(st.nextToken());
            meeting[i][1]=Integer.parseInt(st.nextToken());
        }

        /*
        제일 먼저 끝나는 회의를 찾는다
        그다음 먼저 끝나는 회의를 찾고 앞시간이 더 빠른지 파악한다.
         */

        // 이중배열 두번째 원소기준으로 정렬
        Arrays.sort(meeting, (o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0]-o2[0];
            return o1[1]-o2[1];
        });

        // 카운팅 변수와 이전 회의 종료시간을 변수에 넣는다.
        int count = 0;
        int endTime = -1;

        // 첫 번째 회의시간부터 마지막 회의시간까지 가능한 회의를 찾는다.
        for (int i = 0; i < N; i++) {
            if(endTime <= meeting[i][0]){
                endTime = meeting[i][1];
                count++;
            }
        }
        System.out.println(count);
    }
}
