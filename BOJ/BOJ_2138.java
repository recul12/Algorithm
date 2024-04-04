package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2138 {
    /*
        N개의 스위치와 N개의 전구가 있고 각각의 전구는 켜져 있는 상태와 꺼져 있는 상태 중 하나의 상태를 가진다.
        i(1 < i < N)번 스위치를 누르면 i-1, i, i+1의 세 개의 전구의 상태가 바뀐다.
        즉, 꺼져 있는 전구는 켜지고, 켜져 있는 전구는 꺼지게 된다.
        1번 스위치를 눌렀을 경우에는 1, 2번 전구의 상태가 바뀌고, N번 스위치를 눌렀을 경우에는 N-1, N번 전구의 상태가 바뀐다.
        N개의 전구들의 현재 상태와 우리가 만들고자 하는 상태가 주어졌을 때 스위치를 최소 몇 번 누르는지 구하라.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        int[] want = new int[N];

        String start = br.readLine();
        String end = br.readLine();

        for (int i = 0; i < N; i++) {
            A[i] = start.charAt(i) - '0';
            B[i] = A[i];
            want[i] = end.charAt(i) - '0';
        }

        // 1번 스위치 누른다.
        A[0] = 1 - A[0];
        A[1] = 1 - A[1];
        int pressedResult = pressSwitch(A, want);
        if(pressedResult != -1) pressedResult++;
        // 1번 스위치 안누른다
        int result = pressSwitch(B, want);

        if(pressedResult == -1)
            System.out.println(result);
        else if(result == -1)
            System.out.println(pressedResult);
        else
            System.out.println(Math.min(pressedResult, result));
    }
    private static int pressSwitch(int[] current, int[] want){
        int count = 0;

        for (int i = 1; i < current.length; i++) {
            if(current[i-1] != want[i-1]){
                current[i-1] = 1 - current[i-1];
                current[i] = 1 - current[i];
                count++;
                if(i < current.length-1)
                    current[i+1] = 1 - current[i+1];
            }
        }

        if(current[current.length-1] != want[want.length-1])
            return -1;
        return count;
    }
}
