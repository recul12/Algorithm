package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1182 {
    private static int N;
    private static int S;
    private static int answer;
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 수열에 들어있는 정수의 개수
        N = Integer.parseInt(st.nextToken());
        // 부분수열의 합
        S = Integer.parseInt(st.nextToken());
        // 정답 초기화
        answer=0;
        // 수열 생성
        st=new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0,0);
        // 크기가 양수인 부분수열을 구해야하는데 구하는 S가 0일 경우 공집합이 더해지는 결과가 생긴다.
        // 구하는 S가 0일 때 공집합을 빼주어야 한다.
        if(S == 0) answer--;
        System.out.println(answer);
    }
    // 모든 부분수열의 합을 구하기
    public static void dfs(int L, int sum){
        // 마지막 원소이고 합이 S면 answer +1
        if(L == N){
            if(sum == S) answer++;
            return;
        }
        // 해당 정수 더하기
        dfs(L+1, sum + arr[L]);
        // 해당 정수 더하지 않기
        dfs(L+1, sum);
    }
}
