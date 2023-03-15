package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i]=Integer.parseInt(st.nextToken());
        }

        /*
            투 포인터를 이용하여 풀이
            lt, rt를 설정
            rt를 움직이면서 합이 M을 넘으면 lt를 움직인다.
            lt는 rt를 넘을 수 없다.
         */
        int count = 0; // 수의 합이 M이 되는 경우의 수
        int lt=0,rt=0; // 시작 위치는 0
        while(rt < N) // rt가 N보다 작을 경우에만 계속 반복
        {
            int sum=0;
            for (int i = lt; i <= rt; i++) {
                sum+=A[i];
            }
            if(sum == M){
                count++;
                lt++;
                rt++;
            }else if(sum < M){
                rt++;
            }else{
                lt++;
            }
        }

        System.out.println(count);
    }
}
