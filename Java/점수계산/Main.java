package Algorithm;

/*
OX 문제를 채점하여 점수를 구한다.
채점 기준은 맞은 문제는 1, 틀린 문제는 0으로 두고 연속으로 맞은 경우는 +1을 추가한다.
1 0 1 1 1 0 0 1 1 0 의 순서로 문제를 맞혔다면
1 0 1 2 3 0 0 1 2 0 의 점수를 얻는다.
이 계산을 할 수 있는 프로그램을 만들어라.
 */

import java.util.Scanner;

public class Main {

    public int solution(int n,int[] arr){
        int answer=0,cnt=0;
        int[] tmp=new int[n];
        for(int i=0; i<n;i++){
            if(arr[i]==1){
                cnt+=1;
                tmp[i]=cnt;
            }else cnt=0;
        }

        for(int x:tmp){
            answer+=x;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T=new Main();
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] arr=new int[n];
        for(int i=0; i<n; i++){
            arr[i]=s.nextInt();
        }
            System.out.print(T.solution(n,arr));
    }
}
