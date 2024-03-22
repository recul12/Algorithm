package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_3003 {
    /*
        동혁이는 창고에서 체스판과 피스를 발견했다.
        체스판의 먼지를 털어내고 걸레로 닦으니 쓸만한 체스판이 되었다.
        하지만, 검정색 피스는 모두 있었으나, 흰색 피스는 개수가 이상했다.
        체스는 총 16개의 피스를 사용한다.
        피스들은 킹 1개, 퀸 1개, 룩 2개, 비숍 2개, 나이트 2개, 폰 8개로 구성되어 있다.
        동혁이가 발견한 흰색 피스의 개수가 주어졌을 때, 몇 개를 더하거나 빼야 올바른 세트가 되는지 구하라.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        sb.append(1-Integer.parseInt(st.nextToken())).append(" ")
            .append(1-Integer.parseInt(st.nextToken())).append(" ")
            .append(2-Integer.parseInt(st.nextToken())).append(" ")
            .append(2-Integer.parseInt(st.nextToken())).append(" ")
            .append(2-Integer.parseInt(st.nextToken())).append(" ")
            .append(8-Integer.parseInt(st.nextToken()));

        System.out.println(sb);
    }
}
