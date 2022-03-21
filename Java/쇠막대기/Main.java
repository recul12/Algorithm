package Algorithm;

/*
쇠막대기
쇠막대기를 레이저로 절단.
조건 1. 쇠막대기는 자신보다 긴 쇠막대기 위에만 놓일 수 있다.
조건 2. 각 쇠막대기를 자르는 레이저는 적어도 하나 존재한다.
조건 3. 레이저는 어떤 쇠막대기의 양 끝점과도 겹치지 않는다.
레이저는 여는 괄호와 닿는 괄호로 표현된다.()
쇠막대기도 괄호로 표현된다. 그러나 적어도 하나 이상의 레이저는 포함한다.

 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        Stack<Character> stack=new Stack<>();
        int cnt=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') stack.push(s.charAt(i));
            else{
                stack.pop();
                if(s.charAt(i-1)=='(') cnt+=stack.size();
                else cnt++;
            }
        }
        System.out.println(cnt);
    }

}
