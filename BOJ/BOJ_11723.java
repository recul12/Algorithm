package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_11723 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int M=Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();
        // 연산 수행 프로그램 작성
        // 비어있는 공집합 S가 주어진다.
        // add, remove, check, toggle, all, empty를 용도에 맞게 작성하라.
        int S = 0;
        while(M-->0){
            // 비트마스킹으로 S를 20자리수의 집합으로 만든다.
            st=new StringTokenizer(br.readLine());

            String s=st.nextToken();

            switch (s){
                case "all":
                    S = (1<<21)-1;
                    break;
                case "empty":
                    S = 0;
                    break;
                default:
                    int n = Integer.parseInt(st.nextToken());
                    switch (s) {
                        case "add":
                            S = S | (1 << n);
                            break;
                        case "remove":
                            S = S & ~(1 << n);
                            break;
                        case "check":
                            sb.append((((S & (1 << n)) == 0) ? 0 : 1) + "\n");
                            break;
                        case "toggle":
                            S = S ^ (1 << n);
                            break;
                    }
            }
        }
        System.out.println(sb);
    }
}
