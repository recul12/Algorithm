package Algorithm;

/*
 N개로 이루어진 수열이 주어진다.
 이 수열에서 연속부분수열의 합이 특정숫자 M이 되는 경우가 몇 번 있는지 구하라.
 만약 N=8, M=6이고 수열이 다음과 같다면
 1 2 1 3 1 1 1 2
 합이 6이 되는 연속부분수열은 {2, 1, 3}, {1, 3, 1, 1}, {3, 1, 1, 1}로 총 3가지이다.
 */


import java.util.*;

public class Main {
    public int solution(int n, int m, int[] arr){
        int answer=0, sum=arr[0];
        int lt=0,rt=1;

        while(lt<n){
            if(sum==m) {
                answer++;
                sum-=arr[lt++];
            }
            else if(sum<m) {
                if(rt<n) sum+=arr[rt++];
                else break;
            }
            else sum-=arr[lt++];
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T=new Main();
        Scanner s=new Scanner(System.in);

        int n=s.nextInt();
        int m=s.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=s.nextInt();

        System.out.print(T.solution(n,m,arr));

    }
}
