package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2720 {
    /*
        거스름돈을 주는 프로그램을 작성하고 싶다.
        거스름돈의 액수가 주어지면 쿼터(0.25달러), 다임(0.10 달러), 니켈(0.05달러), 페니(0.01달러) 를 이용하면 된다.
        거스름돈은 항상 5달러 이하이고, 손님이 받는 동전 개수를 최소화하라.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int C = Integer.parseInt(br.readLine());

            int[] array = new int[4];
            while(C>0){
                if(C>=25) {
                    array[0]++;
                    C-=25;
                }else if(C < 25 && C>=10){
                    array[1]++;
                    C-=10;
                }else if(C < 10 && C>=5){
                    array[2]++;
                    C-=5;
                }else{
                    array[3]++;
                    C-=1;
                }
            }

            for (int j = 0; j < 4; j++) {
                System.out.print(array[j]+" ");
            }
            System.out.println();
        }
    }
}
