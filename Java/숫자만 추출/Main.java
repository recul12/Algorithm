package Algorithm;

import java.util.Scanner;

/*
문자, 숫자가 섞여있는 문자열이 주어진다.
그 중 숫자만 추출하여 그 순서대로 자연수를 만드시오.
 */

public class Main {
    public int solution(String str){
        str=str.toUpperCase().replaceAll("[A-Z]","");
        int answer=Integer.parseInt(str);

        return answer;
    }

    public static void main(String[] args) {
        Main T=new Main();
        Scanner s=new Scanner(System.in);
        String str=s.nextLine();
        System.out.println(T.solution(str));
    }
}
