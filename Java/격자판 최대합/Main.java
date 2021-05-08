package Algorithm;

/*
N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력하라.
 */


import java.util.Scanner;

public class Main {

    public int solution(int n, int[][] arr){
        int answer = 0;
        int rowsum, colsum, sum=0, rvsum=0;
        for (int i=0;i<n;i++){
            rowsum=0;
            colsum=0;
            for(int j=0; j<n;j++){
                rowsum+=arr[i][j];
                colsum+=arr[j][i];
            }
            if(answer<rowsum) answer=rowsum;
            else if(answer<colsum) answer=colsum;
        }

        for(int i=0; i<n; i++){
            sum+=arr[i][i];
            rvsum+=arr[i][arr.length-1];
            if(answer<sum) answer=sum;
            else if(answer<rvsum) answer=rvsum;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T=new Main();
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[][] arr=new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n;j++){
                arr[i][j]=s.nextInt();
            }
        }
        System.out.print(T.solution(n,arr));
    }
}
