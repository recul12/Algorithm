package Algorithm;

import java.util.Scanner;

/*
앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열을 회문 문자열이라고 합니다.
문자열이 입력되면 해당 문자열이 회문 문자열이면 "YES", 회문 문자열이 아니면 “NO"를 출력
하는 프로그램을 작성하세요.
 */

public class Main {
    public String solution(String str){
        String answer="";
        str=str.toLowerCase();
        char[] s=str.toCharArray();
        int lt=0,rt=str.length()-1;
        while(lt<rt){
            if(s[lt]!=s[rt]){
                answer="NO";
                break;
            }
            answer="YES";
            lt++;
            rt--;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T=new Main();
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        System.out.println(T.solution(str));
    }
}
