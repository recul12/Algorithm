package Algorithm;

import java.util.Scanner;

/*
알파벳 대문자로 이루어진 문자열을 입력받아 같은 문자가 연속으로 반복되는 경우 반복되는 문자 바로 오른쪽에
반복 횟수를 표기해 문자열을 압축하는 프로그램을 작성하시오. 1은 생략하라.
 */

public class Main {
    public String solution(String str){
        String answer="";
        str=str+" ";
        int cnt=0;
        char p=str.charAt(0);
        for(int i=0;i<str.length();i++) {
            if (p == str.charAt(i)) cnt++;
            else {
                answer+=p;
                if(cnt>1) answer+=String.valueOf(cnt);

                p = str.charAt(i);
                cnt = 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T=new Main();
        Scanner s=new Scanner(System.in);
        String str=s.next();
        System.out.println(T.solution(str));
    }
}
