package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer=666;
        int cnt = 0;

        for (int i = 666; cnt != N ; i++) {
            if(String.valueOf(i).contains("666")) {
                cnt++;
                answer=i;
            }
        }
        System.out.println(answer);
    }
}
