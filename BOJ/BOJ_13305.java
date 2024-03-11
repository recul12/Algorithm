package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_13305 {
    /*
        일직선 도로 위에 있는 N개의 도시가 있다.
        제일 왼쪽 도시에서 가장 오른쪽 도시로 이동하려한다.
        인접한 두 도시 사이의 도로들은 서로 길이가 다를 수 있다.
        처음 출발시 자동차에 기름이 없어서 주유소에서 기름을 넣고 출발하여야 한다.
        기름통 크기는 무제한이어서 얼마든지 많은 기름을 넣을 수 있다.
        도로를 이용하여 이동할 때 1km 마다 1리터 기름을 사용한다.
        각 도시에는 하나의 주유소만 있으며, 도시마다 주유소 리터 당 가격은 다를 수 있다.
        각 도시에 있는 주유소 기름 가격과, 각 도시를 연결하는 도로의 길이를 입력으로 받아 최소 이동비용을 계산하라.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 도시의 개수
        int N = Integer.parseInt(br.readLine());
        // 도로의 길이
        int[] distance = new int[N-1];
        // 총 도로 길이
        StringTokenizer st =new StringTokenizer(br.readLine());
        for (int i = 0; i < distance.length; i++) {
            distance[i]=Integer.parseInt(st.nextToken());
        }
        // 주유소 리터당 가격
        int[] prices = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < prices.length; i++) {
            prices[i]=Integer.parseInt(st.nextToken());
        }

        long result = 0;
        // 첫 번째 도시에서 다음 도시까지는 무조건 첫 번째 도시의 기름값을 내야한다.
        long minPrice = prices[0];

        for (int i = 0; i < N-1; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            result += minPrice * distance[i];
        }

        System.out.println(result);
    }

}
