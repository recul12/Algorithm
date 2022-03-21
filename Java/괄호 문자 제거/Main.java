package Algorithm;

/*
입력된 문자열에서 소괄호 ( ) 사이에 존재하는 모든 문자를 제거하고 남은 문자만 출력하는 프로그램을 작성하라.
 */


import java.util.*;

public class Main {
    public String solution(String s){
        String answer="";
        Stack<Character> stack=new Stack<>();
        for(char c: s.toCharArray()){
            if(c=='('){
                stack.push(c);
            }else if(c==')'){
                stack.pop();
            }else{
                if(stack.isEmpty()) answer+=c;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T=new Main();
        Scanner sc=new Scanner(System.in);

        String s=sc.next();
        System.out.print(T.solution(s));
    }
}
