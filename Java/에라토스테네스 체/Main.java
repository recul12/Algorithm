package Algorithm;

/*
자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하라.
만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 8이 답이 된다.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public int solution(int n){
        if(n<=1) return 0;

        int answer=0;
        ArrayList<Boolean> ch=new ArrayList<>(n+1);

        ch.add(false);
        ch.add(false);

        for(int i=2;i<=n;i++){
            ch.add(true);
        }

        for(int i=2;i*i<=n;i++){
            if(ch.get(i)){
                for(int j=i*i;j<=n;j+=i) ch.set(j,false);
            }
        }

        for(boolean b : ch){
            if(b){
               answer+=1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T=new Main();
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        System.out.println(T.solution(n));
    }
}
