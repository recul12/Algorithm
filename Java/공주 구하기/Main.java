package Algorithm;

/*
왕자 N 명 중 공주를 구하러 갈 왕자를 고르려고 한다.
왕은 왕자들을 나이 순으로 1부터 N까지 번호를 매기고 시계방향으로 동그랗게 앉게 했다.
1번 왕자부터 시계방향으로 1부터 외치게 하고, 한 왕자가 K를 외치면 그 왕자는 공주를 구하러 가는데서 제외한다.
이렇게 공주를 구하러 가는 프로그램을 만들어라.
 */
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();

        Queue<Integer> queue=new LinkedList<>();

        for(int i=1;i<=n;i++){
            queue.offer(i);
        }
        int answer=0;
        while(!queue.isEmpty()){
            for(int i=1; i<k; i++) queue.offer(queue.poll());
            queue.poll();
            if(queue.size()==1) answer=queue.poll();
        }
        System.out.println(answer);
    }

}
