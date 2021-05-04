package Algorithm;

/*
선생님이 N명의 학생을 일렬로 세웠습니다. 일렬로 서 있는 학생의 키가 앞에서부터 순서대로
주어질 때, 맨 앞에 서 있는 선생님이 볼 수 있는 학생의 수를 구하는 프로그램을 작성하세요.
(어떤 학생이 자기 앞에 서 있는 학생들보다 크면 그 학생은 보이고, 작거나 같으면 보이지 않
습니다.)
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public int solution(ArrayList<Integer> arrayList){
        ArrayList<Integer> answer=new ArrayList<>();
        answer.add(arrayList.get(0));
        int p=answer.get(0);
        for(int x : arrayList){
            if(x>p) {
                answer.add(x);
                p=x;
            }
        }

        return answer.size();
    }

    public static void main(String[] args) {
        Main T=new Main();
        Scanner s=new Scanner(System.in);
        ArrayList<Integer> arrayList=new ArrayList<>();
        int n=s.nextInt();
        for(int i=0;i<n;i++){
            arrayList.add(s.nextInt());
        }
            System.out.print(T.solution(arrayList));
    }
}
