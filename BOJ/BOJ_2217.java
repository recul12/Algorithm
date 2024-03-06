package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ_2217 {
    /*
        N개의 로프가 있다.
        각 로프는 들 수 있는 물체의 중량이 다를 수 있다.
        여러개를 병렬로 연결하면 중량을 나눌 수 있다.
        k개의 로프를 사용하여 중량이 w인 물체를 들어올릴 때 각 로프에는 고르게 w/k의 중량이 걸린다.
        이 로프들을 이용하여 들 수 있는 물체의 최대 중량을 구하라.
        모든 로프를 사용할 필요는 없고, 몇 개의 로프를 골라서 사용해도 된다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> ropes = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            ropes.add(Integer.parseInt(br.readLine()));
        }

        // 중량은 가장 작은 중량을 버티는 로프 x 총 사용 로프 개수의 결과다.
        // 그러므로 먼저 정렬을 한다.
        Collections.sort(ropes);
        // 최대 중량 변수를 만든다
        int weight = 0;
        // 필요 로프 개수 k값을 저장한다.
        int k = ropes.size();
        for (int i = 0; i < ropes.size(); i++) {
            weight=Math.max(ropes.get(i) * k--,weight);
        }

        System.out.println(weight);
    }
}
