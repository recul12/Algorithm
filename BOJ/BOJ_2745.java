package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2745 {
    /*
    B진법 수 N이 주어진다.
    이 수를 10진법으로 바꿔 출력하고 싶다.
    10진법을 넘어가는 진법은 숫자로 표시할 수 없는 자리가 있다.
    이런 경우에는 다음과 같이 알파벳 대문자를 사용한다.
    A: 10, B: 11, ..., F: 15, ..., Y: 34, Z: 35
     */
    public static void main(String[] args) throws IOException {
        /*
            각 자리의 값을 그 자리에 맞게 곱한 후 모두 더하면 된다.
            각 대문자 알파벳 A~Z는 아스키코드 변환 후 -55를 해주면 된다(A의 아스키코드 65)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());

        char[] chars = N.toCharArray();
        int num = 0;
        int index = 0;
        long result=0;

        for (int i = chars.length-1; i >= 0; i--) {
            if(chars[i]>='A') {
                num = chars[i] - 55;
            }else {
                num = chars[i]-'0';
            }
            result += num * Math.pow(B, index++);
        }

        System.out.println(result);
    }
}
