package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1629 {
    public static void main(String[] args) throws IOException {
        //자연수 A를 B번 곱한 수를 알고 싶다.
        //단 구하려는 수가 매우 커질 수 있으므로 이를 C로 나눈 나머지를 구하는 프로그램을 작성
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(pow(A,B,C));
    }
    public static long pow(long A, long B, long C){
        // 지수가 1일 경우에는 A를 C로 나눈 것 그대로 리턴하면 된다.
        if(B == 1){
            return A%C;
        }

        // 큰 숫자를 줄이기 위해 지수법칙을 사용하기 위해 지수의 절반 값을 구한다.
        long half = pow(A,B/2,C);

        // 홀수면 A를 추가로 곱하여 리턴
        // 이 때 모듈러 연산을 사용하여 값을 줄인다.
        if(B%2 == 1){
            return (half*half % C) * A % C;
        }

        return half*half % C;
    }
}
