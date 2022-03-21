package Algorithm;

/*
현수는 1부터 100사이의 자연수가 적힌 N장의 카드를 가지고 있다.
같은 숫자의 카드가 여러장 있을 수 있고 현수는 이 중 3장을 뽑아 각 카드에 적힌 수를 합한 값을 기록하려고 한다.
3장을 뽑을 수 있는 모든 경우를 기록하고 기록한 값 중 K번째로 큰 수를 출력하는 프로그램을 작성하라.
만약 큰 수부터 만들어진 수가 25 25 23 23 22 20 19..이고 K값이 3이라면 K번째 큰 값은 22이다.
 */


import java.util.*;

public class Main {
    public int solution(int n, int k, int[] arr){
        int answer=-1;

        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int l=j+1;l<n;l++){
                    set.add(arr[i]+arr[j]+arr[l]);
                }
            }
        }
        if(set.size()<k) return answer;

        ArrayList<Integer> list=new ArrayList<>(set);
        Collections.sort(list,Comparator.reverseOrder());
        answer=list.get(k-1);

        return answer;
    }

    public static void main(String[] args) {
        Main T=new Main();
        Scanner s=new Scanner(System.in);

        int N=s.nextInt();
        int K=s.nextInt();
        int[] arr=new int[N];
        for(int i=0;i<N;i++){
            arr[i]=s.nextInt();
        }
        System.out.print(T.solution(N,K,arr));
    }
}
