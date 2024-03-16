package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16953 {
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

        cnt = Integer.MAX_VALUE;

        solution(A, 1);

        if(cnt == Integer.MAX_VALUE) cnt = -1;
        System.out.println(cnt);
    }

    private static void solution(int A,int count){
        if(A>B) return;
        else if(A<B) {
            solution(A * 2, count+1);
            solution(Integer.parseInt(A + "1"), count+1);
        }
        else {
            cnt = Math.min(count, cnt);
        }
    }
}
