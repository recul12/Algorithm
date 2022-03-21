package Algorithm;

/*
응급실에 의사가 한명밖에없다.
환자가 도착한 순서대로 진료를 하지만, 위험도가 높은 환자는 빨리 응급조치를 해야한다.
이런 문제를 보완하기 위해 진료순서를 다음과 같이 정한다.
환자가 접수한 순서대로의 목록에서 제일 앞에 있는 환자목록을 껀낸다.
나머지 대기 목록에서 꺼낸 환자보다 위험도가 높은 환자가 존재하면 대기목록 제일 뒤로 다시 넣는다. 그렇지 않으면 진료를 받는다.
즉 대기목록에 자기보다 위험도가 높은 환자가 없을 때 자신이 진료를 받는 구조이다.
현재 N명의 환자가 대기 목록에 있다.
N명의 대기목록 환자의 위험도가 주어지면, 대기목록상의 M번째 환자는 몇 번째로 진료를 받는지 출력하라.
M은 대기목록의 처음 환자를 0번째로 간주하여 표현한 것이다.
 */
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
import java.util.*;
class Person{
    int id;
    int priority;
    public Person(int id, int priority){
        this.id=id;
        this.priority=priority;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        Queue<Person> queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            queue.offer(new Person(i,sc.nextInt()));
        }
        int cnt=0;
        while(!queue.isEmpty()){
            Person tmp=queue.poll();
            for(Person p:queue) {
                if (p.priority > tmp.priority) {
                    queue.offer(tmp);
                    tmp=null;
                    break;
                }
            }
            if(tmp!=null){
                cnt++;
                if(tmp.id==m){
                    System.out.println(cnt);
                    break;
                }
            }
        }

    }

}
