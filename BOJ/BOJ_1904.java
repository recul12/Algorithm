package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1904 {

    public static int[] dp = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 0과 1이 쓰여있는 낱장의 타일들
        // 누군가 0이 쓰여진 낱장의 타일을 붙여서 00 타일로 만들었다.
        // 00과 1이 쓰여있는 타일들만이 남아있다
        // 더이상 크기가 N인 모든 2진 수열을 만들 수 없다.
        // N=1일 경우 1, N=2일 경우 00, 11을 만들 수 있다.(01,10은 불가능)
        // N이 주어졌을 때 만들 수 있는 모든 수열의 개수를 구하라.

        int N = Integer.parseInt(br.readLine());

        // 기존에 있던 타일에 타일을 연결하므로 다이나믹 프로그래밍 이용하자

        dp[1]=1;
        dp[2]=2;

        for (int i = 3; i <= N ; i++) {
            dp[i]=(dp[i-2]+dp[i-1])%15746;
        }

        System.out.println(dp[N]);

    }

}
