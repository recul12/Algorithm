package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 듣보잡 수와 명단을 사전순으로 출력하라.
        HashSet<String> hashSet = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            hashSet.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String tmp = br.readLine();
            if(hashSet.contains(tmp)){
                list.add(tmp);
            }
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(String x : list){
            System.out.println(x);
        }

    }
}
