package Algorithm;

/*
인형뽑기 크레인
 */


import java.util.*;

public class Main {
    public int solution(String s){
        int answer=0;
        Stack<Integer> stack=new Stack<>();

        for(char c:s.toCharArray()){
            if(Character.isDigit(c))
                stack.push(c-'0');
            else {
                int x=stack.pop();
                int y=stack.pop();
                if(c=='+') stack.push(y+x);
                else if(c=='-') stack.push(y-x);
                else if(c=='*') stack.push(y*x);
                else if(c=='/') stack.push(y/x);
            }
        }
        answer=stack.get(0);
        return answer;
    }

    public static void main(String[] args) {
        Main T=new Main();
        Scanner sc=new Scanner(System.in);

        String s=sc.next();

        System.out.print(T.solution(s));
    }
}
