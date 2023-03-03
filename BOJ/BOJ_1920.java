package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i]=Integer.parseInt(st.nextToken());
        }

        // 이분 탐색을 위한 배열 정렬
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            if(Arrays.binarySearch(A,Integer.parseInt(st.nextToken())) >= 0)
                System.out.println(1);
            else System.out.println(0);
        }
    }
}
