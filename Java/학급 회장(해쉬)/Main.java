package Algorithm;

/*
학급 회장을 뽑는데 후보로 기호 A, B, C, D, E 후보가 등록을 했다.
투표용지에는 반 학생들이 자기가 선택한 후보의 기호가 쓰여져 있으며 선생님은 기호를 발표하고 있다.
선생님의 발표가 끝난 후 어떤 기호의 후보가 학급 회장이 되었는지 출력하는 프로그램을 작성하라.
단, 반드시 한 명의 학급회장이 선출되도록 투표결과가 나왔다고 가정한다.
 */


import java.util.*;

public class Main {
    public char solution(int n,String s){
        char answer=' ';
        HashMap<Character, Integer> map=new HashMap<>();
        for(char x : s.toCharArray()){
            map.put(x,map.getOrDefault(x, 0)+1);
        }
        int max=Integer.MIN_VALUE;
        for(char key : map.keySet()){
            if(map.get(key)>max){
                max=map.get(key);
                answer=key;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Main T=new Main();
        Scanner s=new Scanner(System.in);

        int n=s.nextInt();
        String string=s.next();

        System.out.print(T.solution(n,string));

    }
}
