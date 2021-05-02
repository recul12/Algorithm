package Algorithm;

import java.util.Scanner;

/*
한개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하라.
 */

public class Main {
    public int[] solution(String str, char t){
        int[] answer=new int[str.length()];
        int p=1000;
        for(int i=0; i<str.length(); i++){
            if(str.charAt(i)==t){
                p=0;
                answer[i]=p;
            }
            else{
                p++;
                answer[i]=p;
            }
        }
        p=1000;
        for(int i=str.length()-1;i>=0;i--){
            if(str.charAt(i)==t) p=0;
            else{
                p++;
                answer[i]=Math.min(answer[i],p);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T=new Main();
        Scanner s=new Scanner(System.in);
        String str=s.next();
        char c=s.next().charAt(0);
        for(int x : T.solution(str, c)){
            System.out.print(x+" ");
        }
    }
}
