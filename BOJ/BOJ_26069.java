package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BOJ_26069 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Set<String> rainbowDanceSet = new HashSet<>();

        StringTokenizer st;

        rainbowDanceSet.add("ChongChong");

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String A = st.nextToken();
            String B = st.nextToken();

            if(rainbowDanceSet.contains(A) || rainbowDanceSet.contains(B)){
                rainbowDanceSet.add(A);
                rainbowDanceSet.add(B);
            }
        }

        System.out.println(rainbowDanceSet.size());
    }
}
