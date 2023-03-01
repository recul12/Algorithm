package Algorithm;

import java.util.Arrays;

public class 숫자_변환하기 {
    /*
    자연수 x를 y로 변환하려고 한다.
    단, 사용할 수 있는 연산은 아래 세 가지 뿐이다.
    1. x에 n을 더한다.
    2. x에 2를 곱한다.
    3. x에 3을 곱한다.
    자연수 x, y, n이 매개변수로 주어질 때,
    x를 y로 변환하기 위해 필요한 최소 연산 횟수를 반환하도록 함수를 완성하라.
    이때 x를 y로 만들 수 없다면 -1을 반환하라.
     */
    public int solution(int x, int y, int n) {
        int answer = 0;
        return answer=dp(x,y,n);
    }
    // DP
    public static int dp(int x,int y, int n){
        // y보다 커질수 없으므로 y까지의 dp 배열을 만든다
        int[] dp = new int[y+1];
        // 최소값을 구하기 위해 모두 적당한 INF 값으로 채워준다
        int INF=1000002;
        Arrays.fill(dp,INF);
        // 시작지점 x를 0으로 설정한다.
        dp[x]=0;
        // x부터 y까지 최소값을 채운다
        for (int i = x; i <= y; i++) {
            if(i + n <= y)
                dp[i+n]=Math.min(dp[i+n],dp[i]+1);
            if(i * 2 <= y)
                dp[i*2]=Math.min(dp[i*2],dp[i]+1);
            if(i * 3 <= y)
                dp[i*3]=Math.min(dp[i*3],dp[i]+1);
        }
        int answer = (dp[y] >= INF) ? -1 : dp[y];
        return answer;
    }
}
