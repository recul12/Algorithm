package Algorithm;

/*
N(1<=N<=100)개의 정수를 입력받아, 자신의 바로 앞 수보다 큰 수만 출력하는 프로그램을 작성하세요.
첫 번째 수는 무조건 출력한다.

 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public ArrayList<Integer> solution(int n, ArrayList<Integer> arrayList){
        ArrayList<Integer> answer=new ArrayList<>();
        answer.add(arrayList.get(0));
        int p=answer.get(0);
        for(int x : arrayList){
            if(x>p) answer.add(x);
            p=x;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T=new Main();
        Scanner s=new Scanner(System.in);
        ArrayList<Integer> arrayList=new ArrayList<>();
        int n=s.nextInt();
        for(int i=0;i<n;i++){
            arrayList.add(s.nextInt());
        }
        for(int x: T.solution(n,arrayList)){
            System.out.print(x+" ");
        }
    }
}
