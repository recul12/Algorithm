package Algorithm;

/*
피보나치 수열을 출력한다.
피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.

입력은 피보나치 수열의 총 항의 수 이다.
만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public ArrayList<Integer> solution(int n){
        ArrayList<Integer> answer=new ArrayList<>();

        for(int i=0;i<n;i++){
            if(i==0||i==1) answer.add(1);
            else{
                answer.add(answer.get(i-1)+answer.get(i-2));
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T=new Main();
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        for(int x: T.solution(n)){
            System.out.print(x+" ");
        }
    }
}
