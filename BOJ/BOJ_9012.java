package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_9012 {
    static int N;
    static Stack<Character> stack;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            stack=new Stack<>();
            char[] chars=br.readLine().toCharArray();
            for (char c: chars) {
                if(c=='(') stack.push('(');
                else {
                    if(stack.isEmpty()){
                        stack.push('e');
                        break;
                    }
                    stack.pop();
                }
            }
            if(stack.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}
