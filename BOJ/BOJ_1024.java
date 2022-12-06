package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1024 {
    // 첫째 줄에 N과 L이 주어진다. N은 1,000,000,000보다 작거나 같은 자연수이고
    // L은 2보다 크거나 같고, 100보다 작거나 같은 자연수이다.

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int L=Integer.parseInt(st.nextToken());

        // N은 수열의 시작값부터 길이 L의 연속된 수의 합
        // 수열의 시작값부터 끝값까지의 덧셈은 s에 L을 곱한 값과 1부터 L-1를 합한 값을 더한 것과 같다.
        // 즉 시작값 * L과 1+...+L-1의 합으로 볼 수 있다
        // N = x(시작값) * L + (1+...+L-1)
        // N = x * L + (L-1)*L/2
        // N-(L-1)*L/2 = x * L
        // N/L-(L-1)/2 = x
        // 수열의 시작값이 나와야하므로 여기서 N/L-(L-1)/2 는 정수가 나와야한다.
        // 즉 N-(L-1)*L/2 를 L로 나누었을 때 나머지가 0이어야만 한다.
        while(L<=100){
            if((N-(L-1)*L/2)%L!=0) L++;
            else{
                int x=N/L-(L-1)/2;
                if(x<0) {
                    L++;
                    continue;
                }
                for (int i = 0; i < L; i++) {
                    System.out.print(x+i+" ");
                }
                break;
            }
        }
        if(L==100) System.out.println("-1");
    }

}
