package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1929 {
    public static void main(String[] args) throws IOException {
        // 소수 구하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // M부터 N을 포함하여 두 숫자 사이의 소수를 구하라
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 에라스토테네스의 체를 이용하여 구하자
        int check[] = new int[N+1];
        // 소수 판정을 위해 2부터 check 배열을 채워준다
        for (int i = 2; i <= N; i++) {
            if(check[i]==0) {
                // i가 M보다 크거나 같은 경우만 출력
                if(i>=M)sb.append(i).append("\n");
                for (int j = i; j <= N; j+=i) {
                    check[j]=1;
                }
            }
        }
        System.out.println(sb);
    }
}
