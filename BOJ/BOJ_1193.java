package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1193 {
    /*
        무한히 큰 배열에 분수들이 적혀있다.
        1/1 1/2 1/3 ...
        2/1 2/2 2/3 ...
        3/1 3/2 3/3 ...
        런 식으로 나열된 분수들을 1/1->1/2->2/1->3/1->2/2 와 같이
        지그재그 순서대로 1,2,3,4,5번 분수라고 하자.
        X가 주어질 때 X번째 분수를 구해라.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        int idx=0;
        while(true){
            if(X > idx*(idx+1)/2){
                idx++;
            }else{
                break;
            }
        }

        int tmp2 = idx%2;
        int position = idx*(idx+1)/2 - X;
        if(tmp2 == 0){
            sb.append(idx-position).append("/").append(1+position);
        }else{
            sb.append(1+position).append("/").append(idx-position);
        }

        System.out.println(sb.toString());
    }
}
