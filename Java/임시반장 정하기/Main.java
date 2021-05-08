package Algorithm;

/*
6학년 1반의 임시 반장을 선출하기 위해 김갑동 선생님은 학생 중에 1~5학년 까지 지내며 한번이라도 같은 반이었던
사람이 가장 많은 학생을 임시 반장으로 선정하려 한다.
각 학생들이 1학년부터 5학년까지 속했던 반이 주어질 때, 임시 반장을 정하는 프로그램을 작성하시오.
 */


import java.util.*;

public class Main {
    public int solution(int n, int[][] arr){
        int answer=0, max=0;
        for(int i=1; i<=n;i++){
            int cnt=0;
            for(int j=1; j<=n; j++){
                for(int k=1;k<=5;k++){
                    if(arr[i][k]==arr[j][k]){
                        cnt++;
                        break;
                    }
                }
            }
            if(cnt>max){
                max=cnt;
                answer=i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T=new Main();
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[][] arr=new int[n+1][6];
        for(int i=1; i<=n; i++){
            for(int j=1; j<=5;j++){
                arr[i][j]=s.nextInt();
            }
        }
        System.out.print(T.solution(n,arr));
    }
}
