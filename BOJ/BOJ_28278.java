package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ_28278 {
    /*
        정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

        명령은 총 다섯 가지이다.

        1 X: 정수 X를 스택에 넣는다. (1 ≤ X ≤ 100,000)
        2: 스택에 정수가 있다면 맨 위의 정수를 빼고 출력한다. 없다면 -1을 대신 출력한다.
        3: 스택에 들어있는 정수의 개수를 출력한다.
        4: 스택이 비어있으면 1, 아니면 0을 출력한다.
        5: 스택에 정수가 있다면 맨 위의 정수를 출력한다. 없다면 -1을 대신 출력한다.
     */
    static ArrayList<Integer> arrayList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        arrayList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            if(x == 1){
                int y = Integer.parseInt(st.nextToken());
                push(y);
            }else if(x == 2){
                sb.append(pop()).append("\n");
            }else if(x == 3){
                sb.append(print()).append("\n");
            }else if(x == 4){
                sb.append(isEmpty()).append("\n");
            }else{
                sb.append(peek()).append("\n");
            }
        }

        System.out.println(sb);
    }

    private static void push(int x){
        arrayList.add(x);
    }

    private static int pop(){
        if(arrayList.isEmpty()) return -1;

        int position = arrayList.size()-1;

        int tmp = arrayList.get(position);

        arrayList.remove(position);

        return tmp;
    }

    private static int print(){
        return arrayList.size();
    }

    private static int isEmpty(){
        if(arrayList.isEmpty()) return 1;
        else return 0;
    }

    private static int peek(){
        if(arrayList.isEmpty()) return -1;

        return arrayList.get(arrayList.size()-1);
    }
}
