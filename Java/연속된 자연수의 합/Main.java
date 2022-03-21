package Algorithm;

/*
양의 정수 N이 입력되면 2개 이상의 연속된 자연수의 합으로 정수 N을 표현하는
방법의 가짓수를 출력하는 프로그램을 작성하라.
만약 N=15이면
7+8=15
4+5+6=15
1+2+3+4+5=15
와 같이 총 3가지의 경우가 존재한다.

 */


import java.util.*;

public class Main {
    public int solution(int n){
        int answer=0,pos=n/2;
        int[] arr=new int[n/2+1];
        for(int i=n/2; i>=0; i--){
            arr[i]=i+1;
        }
        int lt=pos-1,rt=pos;

        while(true){
            int sum=0;
            for(int j=rt;j>=lt;j--) {
                sum += arr[j];
            }
            if(sum==n) {
                answer+=1;
                rt--;
                lt--;
            }
            else if(sum>n) rt--;
            else lt--;

            if(lt<0) break;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T=new Main();
        Scanner s=new Scanner(System.in);

        int n=s.nextInt();

        System.out.print(T.solution(n));

    }
}
