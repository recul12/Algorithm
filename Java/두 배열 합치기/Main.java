package Algorithm;

/*
오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하라.
 */


import java.util.*;

public class Main {
    public ArrayList<Integer> solution(int[] arr1, int[] arr2){
        ArrayList<Integer> answer=new ArrayList<>();

        int p1=0,p2=0;
        while(p1<arr1.length && p2<arr2.length){
            if(arr1[p1]<=arr2[p2]){
                answer.add(arr1[p1]);
                p1++;
            }else{
                answer.add(arr2[p2]);
                p2++;
            }
        }

        if(p1<arr1.length) {
            for (int i = p1; i < arr1.length; i++) answer.add(arr1[i]);
        }
        if(p2<arr2.length) {
            for (int i = p2; i < arr2.length; i++) answer.add(arr2[i]);
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

        for(int x:T.solution(arr1,arr2)){
            System.out.print(x+" ");
        }
    }
}
