package Algorithm;

/*
괄호가 입력되면 올바른 괄호이면 “YES", 올바르지 않으면 ”NO"를 출력하라.
(())() 이것은 괄호의 쌍이 올바르게 위치하는 거지만, (()()))은 올바른 괄호가 아니다.
 */


import java.util.*;

public class Main {
    public String solution(String s){
        String answer="YES";
        Stack<Character> stack=new Stack<>();
        for(char c: s.toCharArray()){
            if(c=='('){
                stack.push(c);
            }else if(c==')'){
                if(stack.isEmpty()){
                    answer="NO";
                    break;
                }
                stack.pop();
            }
        }
        if(!stack.isEmpty())
            answer="NO";

        return answer;
    }

    public static void main(String[] args) {
        Main T=new Main();
        Scanner sc=new Scanner(System.in);

        String s=sc.next();
        System.out.print(T.solution(s));
    }
}
