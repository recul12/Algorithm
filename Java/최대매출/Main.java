package Algorithm;

/*
제과점을 운영하는 현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 최대 매출액을 구하라고 했다.
만약 N=10이고 10일 간의 매출기록이 이렇게 주어진다.
12 15 11 20 25 10 20 19 13 15
이때, K=3이면 연속된 3일간의 최대 매출액은 11+20+25=56만원이다.
이 프로그램을 작성하라.
 */


import java.util.*;

public class Main {
    public int solution(int n, int k, int[] arr){
        int answer=0, sum=0;

        for(int i=0;i<k;i++) sum+=arr[i];
        answer=sum;

        for(int i=k;i<n;i++){
            sum+=(arr[i]-arr[i-k]);
            answer=Math.max(answer,sum);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T=new Main();
        Scanner s=new Scanner(System.in);

        int n=s.nextInt();
        int k=s.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=s.nextInt();

        System.out.print(T.solution(n,k,arr));

    }
}
