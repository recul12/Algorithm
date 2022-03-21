package Algorithm;

/*
현수의 아빠는 제과점을 운영한다.
현수아빠는 현수에게 N일 동안의 매출기록을 주고 연속된 K일 동안의 매출액의 종류를 각 구간별로 구하라고 했다.
만약 N=7이고 7일 간의 매출기록이 아래와 같고, 이때 K=4이면
20 12 20 10 23 17 10
각 연속 4일간의 구간의 매출종류는
첫 번째 구간은 [20, 12, 20, 10]는 매출액의 종류가 20, 12, 10으로 3이다.
두 번째 구간은 [12, 20, 10, 23]는 매출액의 종류가 4이다.
세 번째 구간은 [20, 10, 23, 17]는 매출액의 종류가 4이다.
네 번째 구간은 [10, 23, 17, 10]는 매출액의 종류가 3이다.
N일간의 매출기록과 연속구간의 길이 K가 주어지면 첫 번째 구간부터 각 구간별 매출액의 종류를 출력하라.
 */


import java.util.*;

public class Main {
    public int solution(String s, String t){
        int answer=0;
        int lt=0;
        HashMap<Character,Integer> am=new HashMap<>();
        HashMap<Character,Integer> bm=new HashMap<>();
        for(char x:t.toCharArray()){
            am.put(x, am.getOrDefault(x,0)+1);
        }
        int L=t.length()-1;
        for(int i=0;i<L;i++) bm.put(s.charAt(i),bm.getOrDefault(s.charAt(i),0)+1);

        for(int rt=L;rt<s.length();rt++){
            bm.put(s.charAt(rt),bm.getOrDefault(s.charAt(rt),0)+1);
            if(bm.equals(am)) answer++;
            bm.put(s.charAt(lt),bm.get(s.charAt(lt))-1);
            if(bm.get(s.charAt(lt))==0) bm.remove(s.charAt(lt));
            lt++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Main T=new Main();
        Scanner s=new Scanner(System.in);

        String s1=s.next();
        String t=s.next();

        System.out.print(T.solution(s1,t));

    }
}
