package Algorithm;

/*
A, B 두 사람이 가위바위보 게임을 한다. 총 N번의 게임을 하여 A가 이기면 A를 출력하고,
B가 이기면 B를 출력. 비길 경우에는 D를 출력한다.
가위, 바위, 보의 정보는 1:가위, 2:바위, 3:보로 정하고
두 사람의 각 회의 가위, 바위 , 보 정보가 주어지면 각 회를 누가 이겼는지 출력하라.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public String solution(int n, int[] a, int[] b){
        String answer="";
        for(int i=0; i<n; i++){
            if(a[i]==b[i]) answer+="D";
            else if(a[i]==1 && b[i]==3) answer+="A";
            else if(a[i]==2 && b[i]==1) answer+="A";
            else if(a[i]==3 && b[i]==2) answer+="A";
            else answer+="B";
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T=new Main();
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        int[] a=new int[n];
        int[] b=new int[n];
        for(int i=0; i<n; i++){
            a[i]=s.nextInt();
        }
        for(int i=0; i<n; i++){
            b[i]=s.nextInt();
        }
        for(char x : T.solution(n, a, b).toCharArray()) System.out.println(x);
    }
}
