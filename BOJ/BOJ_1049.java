package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1049 {
    /*
        기타에서 N개의 줄이 끊어졌다.
        최대한 적은 돈으로 6줄 패키지 혹은 1개 또는 그 이상의 줄을 낱개로 살 수 있다.
        끊어진 기타줄 개수 N과 기타줄 브랜드 M이 주어진다.
        각 브랜드에서 파는 기타줄 6개가 들어있는 패키지의 가격, 낱개로 살 때의 가격이 주어질 때,
        적어도 N개를 사기 위해 필요한 돈의 수를 최소로 하는 프로그램을 작성하시오.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int result = 0;

        int packageMin = 1000;
        int stringMin = 1000;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            packageMin = Math.min(packageMin, Integer.parseInt(st.nextToken()));
            stringMin = Math.min(stringMin, Integer.parseInt(st.nextToken()));
        }

        int q = N / 6;
        int r = N % 6;

        if(packageMin < stringMin * 6) result += packageMin*q;
        else result += stringMin*6*q;
        if(packageMin < stringMin * r) result += packageMin;
        else result += stringMin*r;

        System.out.println(result);
    }
}
