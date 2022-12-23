package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 양수 A가 N의 진짜 약수가 되려면, N이 A의 배수이고, A가 1과 N이 아니어야 한다
        // 1 과 N을 제외한 모든 약수이므로 최소값과 최대값을 곱해주면 된다.
        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 최대값과 최소값 초기화
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        // 주어진 진짜 약수의 개수만큼 반복문을 돌아서 최대값과 최소값을 찾는다
        while(num-- > 0){
            int tmp = Integer.parseInt(st.nextToken());
            if(max < tmp) max = tmp;
            if(min > tmp) min = tmp;
        }
        // 결과 출력
        System.out.println(max * min);
    }
}
