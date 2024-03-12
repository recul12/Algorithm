package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1783 {
    /*
        병든 나이트가 N x M 크기 체스판의 가장 왼쪽 아래에 위치해있다.
        나이트는 4가지 방법으로 움직일 수 있다.
        1. 2칸 위로, 1칸 오른쪽
        2. 1칸 위로, 2칸 오른쪽
        3. 1칸 아래로, 2칸 오른쪽
        4. 2칸 아래로, 1칸 오른쪽
        방문한 칸의 수를 최대로 하려고 한다.
        나이트의 이동 횟수가 4번보다 적지 않다면, 이동 방법을 모두 사용해야한다.
        이동 횟수가 4번보다 적은 경우 이동 방법에 대한 제약이 없다.
        체스판 크기가 주어졌을 때, 병든 나이트가 여행에서 방문할 수 있는 칸의 최대 개수를 구해보자.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        /*
            나이트는 오른쪽으로만 이동하므로 결국 1, 4 번을 반복하면 최대가 된다.
            하지만 그러려면 N이 3 이상이어야만 하고, 1,2,3,4번 이동을 모두 사용해야하므로 M이 7과 같거나 초과인 경우만 해당한다.
            즉 N이 3 이상이고 M이 7 이상이면 1,2,3,4를 전부 이동한 횟수, 방문숫자 5부터 M이 늘어나는 순간 1씩 추가가 가능하다.
            즉 M-2로 볼 수 있다.
            N=1인 경우는 움직이는 것이 불가능하므로 M이 몇이든 1이 답.
            N=2인 경우는 이동횟수가 4번보다 적어야하므로 2,3 번 이동방법만을 3번 써서 M을 7칸 까지만 사용할 수 있다.
            마지막으로 N=3 이지만 M이 7보다 작은 경우에는 결국 모든 이동방법을 사용할 수 없으므로 가로칸 1칸에 1이동씩 늘어나는것이 최선이다.
        */

        int result = 0;

        if(N == 1){
            result = 1;
        }else if(N == 2){
            // N=2 일 때 M=1 이면 1, M=2 이여도 1, M=3이면 2, M=4이면 2... M=7이상이면 4 까지 온다. 즉 (M+1) / 2 의 식이 성립한다.
            result = Math.min(4, (M + 1) / 2);
        }
        else{
            if(M >= 7){
                result = M-2;
            }else{
                result = Math.min(4,M);
            }
        }

        System.out.println(result);
    }
}
