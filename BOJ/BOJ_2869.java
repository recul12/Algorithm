package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2869 {
    /*
        땅 위에 달팽이가 있다.
        이 달팽이는 높이가 V미터인 나무 막대를 올라갈 것이다.
        달팽이는 낮에 A미터 올라갈 수 있다.
        하지만, 밤에 잠을 자는 동안 B미터 미끄러진다.
        정상에 올라간 후에는 미끄러지지 않는다.
        달팽이가 나무 막대를 모두 올라가려면 며칠이 걸릴지 구하라.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        br.close();

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        // 결국 마지막에는 밤에 안미끄러진다. 나무막대에서 미끄러지는 거리를 빼줘야한다.
        // 올라가야하는 날과 낮-밤을 곱해주면 나무막대-밤의 결과임을 알 수있다.
        // 올라가야하는 날 x (낮에 올라가야하는 거리-밤에 내려오는 거리) = 나무막대 - 밤에 미끄러지는 거리
        // 올라가야하는 날을 구해야하므로 나무-밤 / 낮-밤 이 될 것이다.
        // 여기서 나머지가 있다면 1을 추가해주면 된다.
        int count = (V - B) / (A - B);
        if ((V - B) % (A - B) != 0) {
            count++;
        }

        System.out.println(count);
    }
}
