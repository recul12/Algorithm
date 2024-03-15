package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_18310 {
    /*
        일직선 상에 여러 채의 집이 있다.
        특정 위치 집에 한 개의 안테나를 설치하려고 한다.
        효율을 위해서 안테나로부터 모든 집까지 거리가 최소가 되도록 설치하려한다.
        동일한 위치에 여러 개의 집이 존재하는 것이 가능하고, 집이 위치한 곳에만 안테나를 설치할 수 있다.
        집들의 위치 값이 주어질 때, 안테나를 설치할 위치를 선택하는 프로그램을 작성하라.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());

        int house[]= new int[N];
        for (int i = 0; i < N; i++) {
            house[i]=Integer.parseInt(st.nextToken());
        }

        int antenna = 0;

        Arrays.sort(house);

        antenna = house[(N-1)/2];

        System.out.println(antenna);
    }
}
