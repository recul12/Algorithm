package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1541 {
    /*
        세준이는 양수와 +,-, 그리고 괄호를 이용하여 식을 만들었다.
        그리고 괄호를 모두 지웠다.
        그 후에 괄호를 적절히 쳐서 식의 값을 최소로 만드려고 한다.
        괄호를 적절히 쳐서 식의 값을 최소로 만들어라.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String x = br.readLine();

        System.out.println(minValue(x));
    }

    /*
        '-' 를 기준으로 나눈다
        50+50-50+50-50-50과 같은 식이 있으면
        50+50 50+50 50 50 으로 나눈다.
        여기서 다시 '+'를 기준으로 더해주고 나눠진 식끼리 빼주면 된다.
     */

    private static int minValue(String x){
        // split 함수로 -를 기준으로 나눈다.
        String[] minus = x.split("-");

        // 첫 식은 더해준다. - 기준 뒤에 있는 모든 식은 뺄셈이 된다.
        int result=sum(minus[0]);

        // 두 번째 식부터는 마이너스
        for (int i = 1; i < minus.length; i++) {
            result-=sum(minus[i]);
        }

        return result;
    }

    private static int sum(String minus){
        String plus[] = minus.split("\\+");
        int sum=0;

        for (int i = 0; i < plus.length; i++) {
            sum+=Integer.parseInt(plus[i]);
        }

        return sum;
    }
}
