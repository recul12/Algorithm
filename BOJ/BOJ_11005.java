package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11005 {
    /*
        10진법 수 N이 주어진다.
        이 수를 B 진법으로 바꿔 출력하고 싶다.
        10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다.
        이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
        A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        while(N > 0){
            int tmp = N % B;
            char c;
            if (tmp < 10){
                c = (char)('0' + tmp);
            }else{
                c = (char)('A' + tmp - 10);
            }
            sb.insert(0, c);
            N /= B;
        }

        System.out.println(sb.toString());
    }
}
