package Algorithm;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public String solution(String str){
        String answer="";
        int count=0;
        StringTokenizer stringTokenizer=new StringTokenizer(str);
        while(stringTokenizer.hasMoreTokens()){
            String tmp=stringTokenizer.nextToken();
            if(tmp.length()>count){
                count=tmp.length();
                answer=tmp;
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
