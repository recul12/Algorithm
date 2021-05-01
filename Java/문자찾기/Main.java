package Algorithm;

import java.util.Scanner;

public class Main {
    public int solution(String str, char t){
        int answer=0;
        str=str.toUpperCase();
        t=Character.toUpperCase(t);
        for(int i=0;i<str.length();i++){
            //str과 t를 비교
            if(str.charAt(i)==t){
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T=new Main();
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        char c=s.nextLine().charAt(0);
        System.out.println(T.solution(str,c));
    }
}
