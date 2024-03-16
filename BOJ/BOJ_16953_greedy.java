package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16953_greedy {
    /*
        정수 A를 B로 바꾸려고 한다. 가능한 연산은 다음과 같은 두 가지이다.
        1. 2를 곱한다.
        2. 1을 수의 가장 오른쪽에 추가한다.
        A를 B로 바꾸는데 필요한 연산의 최솟값을 구해보자.
     */
    static int A,B,cnt;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        cnt = 1;

        // B가 A보다 작으면 B를 2로 나눌때 나머지가 0인지, 10으로 나눌때 나머지가 1이 되는지를 계산한다.
        // 둘 다 아니라면 가능한 연산이 아니므로 탈출
        // A가 B와 같아질때까지 연산한다.
        while(A < B){
            if(B % 2 == 0) B >>= 1;
            else if(B % 10 == 1) B /= 10;
            else break;
            cnt++;
        }

        if(A == B) System.out.println(cnt);
        else System.out.println("-1");
    }

}
