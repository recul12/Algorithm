package Algorithm;

/*
현수는 1년 수업계획을 짜야한다.
수업중 필수과목은 반드시 이수해야하며, 그 순서도 정해져 있다.
만약 총 과목이 A B C D E F G이고, 여기서 필수가 CBA라면, CBA의 순서대로 수업계획을 짜야한다.
즉, A과목은 B,C를 모두 이수하고 이수해야한다.
수업 계획서상의 각 과목이 무조건 이수된다고 가정하고 N개의 수업설계가 잘 된것이면 YES, 아니면 NO를 출력하라.
 */
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String s2=sc.next();

        Queue<Character> queue=new LinkedList<>();
        String answer="NO";
        for(char c:s.toCharArray()){
            queue.offer(c);
        }
        for(char c:s2.toCharArray()){
            if(c==queue.peek()) queue.poll();
            if(queue.isEmpty()){
                answer="YES";
                break;
            }
        }
        System.out.println(answer);
    }

}
