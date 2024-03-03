package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1740 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        System.out.println(calculate(N));

    }

    public static long calculate(long N){
        long base=1;
        long result = 0;
        long bit = N;
        for (int i = 1; i < 64; i++) {
            if((bit & 1) == 1) result+=base;
            base*=3;
            bit=bit>>1;
        }
        return result;
    }
}
