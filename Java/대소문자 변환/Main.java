package Algorithm;

import java.util.Scanner;

public class Main {
    public String solution(String str){
        String answer="";
        for(char x: str.toCharArray()){
            //대문자는 소문자로, 소문자는 대문자로
            if(Character.isUpperCase(x)) {
                answer += Character.toLowerCase(x);
            }else{
                answer += Character.toUpperCase(x);
            }
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
