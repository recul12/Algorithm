package Algorithm;

import java.util.Scanner;

/*
현수는 영희에게 알파벳 대문자로 구성된 비밀편지를 매일 컴퓨터를 이용해 보내기로 한다.
비밀편지는 현수와 영희가 서로 약속한 암호로 구성되어 있다
비밀편지는 알파벳 한 문자마다 # 또는 * 기호로 7개의 길이로 만들어진다.
만약 현수가 “#*****#”으로 구성된 문자를 보냈다면 영희는 현수와 약속한 규칙대로 다음과 같이 해석한다.

1. “#*****#”를 일곱자리의 이진수로 변환한다. #은 이진수의 1로, *이진수의 0으로 변환되어 결과는 1000001이다.

2. 바뀐 2진수를 10진수화 한다. 1000001을 10진수화 하면 65가 된다.

3. 아스키 번호가 65문자로 변환되어 'A'를 뜻한다.

현수가 4개의 문자를 다음과 같이 신호로 보냈다면
#****###**#####**#####**##**

이 신호를 4개의 문자신호로 구분하면
#****## --> 'C'
#**#### --> 'O'
#**#### --> 'O'
#**##** --> 'L'
최종적으로 “COOL"로 볼 수 있다.
현수가 보낸 신호를 해석해주는 프로그램을 작성하라.
 */

public class Main {
    public String solution(int n, String str){
        String answer="";
        str=str.replace("#","1");
        str=str.replace("*","0");
        String[] s=new String[n];
        int[] ascii=new int[n];
        char[] c=new char[n];
        int pos=0;
        for(int i=0; i<n; i++){
            s[i]=str.substring(pos,pos+7);
            ascii[i]=Integer.parseInt(s[i],2);
            c[i]=(char) ascii[i];
            pos+=7;
        }
        answer=String.valueOf(c);

        return answer;
    }

    public static void main(String[] args) {
        Main T=new Main();
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        String str=s.next();
        System.out.println(T.solution(n, str));
    }
}
