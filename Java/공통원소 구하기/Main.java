package Algorithm;

/*
A, B 두 개의 집합이 주어지면 두 집합의 공통 원소를 추출하여 오름차순으로 출력하는 프로그램을 작성하라.
 */


import java.util.*;

public class Main {
    public ArrayList<Integer> solution(int n, int m, int[] arr1, int[] arr2){
        ArrayList<Integer> answer=new ArrayList<>();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int p1=0,p2=0;
        while(p1<n && p2<m){
            if(arr1[p1]<arr2[p2]) p1++;
            else if(arr1[p1]>arr2[p2]) p2++;
            else{
                answer.add(arr1[p1++]);
                p2++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T=new Main();
        Scanner s=new Scanner(System.in);

        int n=s.nextInt();
        int[] arr1=new int[n];
        for(int i=0;i<n;i++) arr1[i]=s.nextInt();
        int m=s.nextInt();
        int[] arr2=new int[m];
        for(int i=0;i<m;i++) arr2[i]=s.nextInt();

        for(int x:T.solution(n,m,arr1,arr2)){
            System.out.print(x+" ");
        }
    }
}
