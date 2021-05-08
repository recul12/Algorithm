package Algorithm;

/*
N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력하라.
 */


import java.util.*;

public class Main {
    int[] dx={-1,0,1,0};
    int[] dy={0,1,0,-1};

    public int solution(int n, int[][] arr){
        int answer=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                boolean flag=true;
                for(int k=0;k<4;k++){
                    int x=i+dx[k];
                    int y=j+dy[k];
                    if(x>=0 && x<n && y>=0 && y<n && arr[x][y]>=arr[i][j]){
                        flag=false;
                        break;
                    }
                }
                if(flag) answer++;
            }
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
