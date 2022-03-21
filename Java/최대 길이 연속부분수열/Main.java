package Algorithm;

/*
0과 1로 구성된 길이가 N인 수열이 주어진다.
이 수열에서 최대 k번을 0을 1로 변경할 수 있다.
최대 k번의 변경을 통해 이 수열에서 1로만 구성된 최대 길이의 연속부분수열을 찾는 프로그램을 작성하라.
만약 길이가 길이가 14인 다음과 같은 수열이 주어지고 k=2라면
1 1 0 0 1 1 0 1 1 0 1 1 0 1
만들 수 있는 1이 연속된 연속부분수열은 1 1 0 0 1 1 1 1 1 1 1 1 0 1 이며 그 길이는 8이다.

 */


import java.util.*;

public class Main {
    public int solution(int n,int k, int[] arr){
        int answer=0, cnt=0;
        int lt=0;

        for(int rt=0;rt<n;rt++){
            if(arr[rt]==0) cnt++;
            while(cnt>k){
                if(arr[lt]==0) cnt--;
                lt++;
            }
            answer=Math.max(rt-lt+1, answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T=new Main();
        Scanner s=new Scanner(System.in);

        int n=s.nextInt();
        int k=s.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=s.nextInt();
        }

        System.out.print(T.solution(n,k,arr));

    }
}
