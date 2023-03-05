package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        // 풍선을 보관할 덱 생성
        // 풍선 번호와 풍선이 가지고 있는 쪽지번호를 저장한다
        ArrayDeque<int[]> arrayDeque = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arrayDeque.add(new int[]{i+1,Integer.parseInt(st.nextToken())});
        }
        // 1번 풍선에서 나온 숫자
        int num = arrayDeque.pollFirst()[1];
        // 1번부터 시작이므로 정답에 "1 "문자열 추가
        sb.append("1 ");
        // 1번 풍선을 터트려서 나온 숫자만큼 이동하여 터트린다.
        while(!arrayDeque.isEmpty()){
            // 다음에 올 풍선을 null로 먼저 지정해놓고 마지막에 채워준다
            int[] nextNum=null;
            // 숫자만큼 이동
            // num이 양수일 때
            if(num > 0) {
                // num 풍선부터 시작이므로 1부터 시작
                for (int i = 1; i < num; i++) {
                    // num 이 양수이므로 앞쪽에 있는 숫자를 뒤로 옮긴다
                    arrayDeque.addLast(arrayDeque.pollFirst());
                }
                nextNum= arrayDeque.pollFirst();
            }
            //num이 음수일 때
            else
            {
                //num이 음수부터 시작이므로 num부터 시작
                for (int i = num; i < -1; i++) {
                    arrayDeque.addFirst(arrayDeque.pollLast());
                }
                nextNum=arrayDeque.pollLast();
            }
            num = nextNum[1];
            sb.append(nextNum[0]).append(" ");
        }
        System.out.println(sb);
    }
}
