package Algorithm;

/*
현수네 반 선생님은 학생들의 수학점수 향상을 위해 멘토링 시스템을 만드려고 한다.
선생님은 M번의 수학테스트 등수를 가지고 멘토와 멘티를 정한다.
만약 A가 멘토이고, B가 멘티가 되는 짝이 되었다면, A학생은 M번의 수학테스트에서 모두 B학생보다 등수가 앞서야한다.
M번의 수학성적이 주어지면 멘토와 멘티가 되는 짝을 만들수 있는 경우가 총 몇가지인지 구하는 프로그램을 작성하라.
 */


import java.util.*;

public class Main {
    public int solution(int n,int m, int[][] arr){
        int answer=0;

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                int cnt=0;
                for(int k=0;k<m;k++){
                    int pi=0,pj=0;
                    for(int l=0;l<n;l++){
                        if(arr[k][l]==i) pi=l;
                        if(arr[k][l]==j) pj=l;
                    }
                    if(pi<pj) cnt++;
                }
                if(cnt==m) answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T=new Main();
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int m=s.nextInt();
        int[][] arr=new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n;j++){
                arr[i][j]=s.nextInt();
            }
        }

        System.out.print(T.solution(n,m,arr));
    }
}
