package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class BOJ_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        // Arrays 정렬을 위해 Integer로 배열 생성
        Integer[] A = new Integer[N];
        Integer[] B = new Integer[N];
        st = new StringTokenizer(br.readLine());
        // 가장 큰값과 가장 작은값을 매칭시키기 위해서 A는 오름차순, B는 내림차순 정렬한다.
        for (int i = 0; i < N; i++) {
            A[i]=Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            B[i] =Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        Arrays.sort(B, Comparator.reverseOrder());

        int answer=0;
        for (int i = 0; i < N; i++) {
            answer += A[i] * B[i];
        }

        System.out.println(answer);
    }
}
