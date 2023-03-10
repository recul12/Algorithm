package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1476 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int E, S, M;

        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        /*
            E의 범위는 1~15
            S의 범위는 1~28
            M의 범위는 1~19
            우리의 1년은 준규의 1 1 1
            15년은 15 15 15
            16년은 1 16 16
            30년은 15 2 11
            주어진 E S M 으로 우리 년도는 몇 년인지 구하라.
         */

        // 계산기를 만들어 보자
        // 1씩 증가하는 count를 만들고
        // E는 15가 넘으면 초기화, S는 28, M은 19

        int count=0; // 정답
        int x=0,y=0,z=0; // E,S,M
        while(!(x==E && y==S && z==M)){
            x=x%15+1;
            y=y%28+1;
            z=z%19+1;
            count++;
        }
        System.out.println(count);

    }
}
