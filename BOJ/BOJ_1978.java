package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer = 0;
        for (int i = 0; i < N; i++) {
            boolean bool = true;

            int tmp = Integer.parseInt(st.nextToken());
            if(tmp==1){
                continue;
            }
            for (int j = 2; j <= Math.sqrt(tmp); j++) {
                if(tmp % j == 0){
                    bool = false;
                    break;
                }
            }
            if(bool) answer++;
        }
        System.out.println(answer);
    }
}
