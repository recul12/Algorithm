package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_5086 {
    /*
        두 수가 주어졌을 때, 약수(factor)인지, 배수(multiple)인지, 둘 다 아닌지(neither) 구하라.
        두 수가 같은 경우는 없다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if(A == B) break;

            if(A % B == 0) System.out.println("multiple");
            else if(B % A == 0) System.out.println("factor");
            else System.out.println("neither");
        }
    }
}

