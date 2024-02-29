package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1021 {
    static int count=0;
    static int capacity=0;
    static int head;
    static int tail;
    static int queue[];
    static int N,M;


    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        /*
            N개의 원소를 포함하고 있는 양방향 순환 큐에서 몇 개의 원소를 뽑아내려고 한다.
            다음 연산 수행 가능하다.
            1. 첫 번째 원소를 뽑아낸다.
            2. 왼쪽으로 한 칸 이동시킨다.
            3. 오른쪽으로 한 칸 이동시킨다.
            큐의 크기 N과 처음에 포함되어 있는 수의 개수 M이 주어지고 뽑아내려고 하는 원소의 위치가 주어진다.
            원소를 주어진 순서대로 뽑아내는데 드는 2,3번 연산의 최솟값을 출력하자.
         */

        /*
            arraydeque 없는 풀이
            1. 뽑아낼 위치가 들어있는 배열(pick)을 생성한다.
            2. N의 크기를 가지고 있는 큐를 생성한다.
            3. 큐가 회전하는 것처럼 보이게하기 위해 head, tail 포인터를 생성한다.
            4. 첫 번째 원소를 뽑아내는 코드를 작성한다.
            5. 왼쪽으로 이동시키는 코드를 작성한다.
                5-1. 오른쪽 끝의 원소를 저장한다.
                5-2. 오른쪽 끝의 원소를 삭제하고 포인터를 옮긴다.
                5-3. 왼쪽 끝으로 저장한 원소를 옮긴다.
            6. 오른쪽으로 이동시키는 코드를 작성한다.
                6-1. 왼쪽 끝의 원소를 저장한다.
                6-2. 왼쪽 끝의 원소를 삭제하고 포인터를 옮긴다.
                6-3. 오른쪽 끝으로 저장한 원소를 옮긴다.
            7. 구하려는 위치에 가까운 방향으로 이동할 방향을 구하는 코드를 작성한다.
            8. pick 배열에 있는 위치의 원소들로 이동하면서 원소들을 뽑아낸다.
         */
        StringTokenizer st = new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken()); // 50보다 작거나 같은 자연수
        M=Integer.parseInt(st.nextToken()); // N보다 작거나 같은 자연수

        st=new StringTokenizer(br.readLine());
        int pick[] = new int[M];
        for (int i = 0; i < M; i++) {
            pick[i]=Integer.parseInt(st.nextToken());
        }

        capacity = N+1; // 회전하는 큐의 용량
        queue = new int[capacity]; // 회전하는 큐의 역할을 할 배열 생성
        /*
            배열에 가장 처음 큐에서의 위치를 저장한다.
         */
        for (int i = 0; i < N; i++) {
            queue[i]=i+1;
        }
        head = 0; // 0에 위치하는 머리 포인터
        tail = N; // 배열 끝에 위치하는 꼬리 포인터. tail이 있어야할 자리는 배열 내용물이 null이거나 head자리.

        /*
            뽑아내려는 원소 개수 M 만큼 원소를 뽑아내는 연산을 수행
         */
        for (int i = 0; i < M; i++) {
            /*
                target : 뽑아야하는 수의 위치
                dir : 왼쪽 오른쪽 중 target과 가까운 방향을 가리키는 상수
             */
            int target = findTarget(pick[i]);
            int dir = findDirection(target);
            if(dir==1){
                while(queue[head]!=pick[i]) {
                    int tmp = removeFirst();
                    addLast(tmp);
                    count++;
                }
                removeFirst();
            }
            else if(dir==0){
                while(queue[head]!=pick[i]) {
                    int tmp=removeLast();
                    addFirst(tmp);
                    count++;
                }
                removeFirst();
            }
        }

        System.out.println(count);
    }

    /**
     *
     * @param pick : 뽑아내려는 원소(처음 위치)
     * @return : 뽑아내려는 원소가 위치한 자리
     */
    private static int findTarget(int pick) {
        int result = 0;
        for (int i = 0; i < queue.length; i++) {
            if(queue[i] == pick) {
                result = i;
                break;
            }
        }
        return result;
    }

    static final int distance(int from, int to, int length){
        return (to-from+length)%length;
    }

    static final int findDirection(int target){
        // 왼쪽이면 0, 오른쪽이면 1을 반환한다.(같은 값이면 어느 방향이든 상관 없다.)
        int length = capacity;
        if(distance(head, target, length) <= distance(target, tail, length)) return 1;
        else return 0;
    }

    /*
        큐 앞에 원소 추가
     */
    static void addFirst(int x){
        head = dec(head, capacity);
        queue[head]=x;
        if(head==tail){
            grow();
        }
    }

    /*
        큐 뒤에 원소 추가
     */
    static void addLast(int x){
        queue[tail] = x;
        if(head==(tail = inc(tail, capacity))) {
            grow();
        }
    }

    static void grow(){
        queue = Arrays.copyOf(queue, capacity++);
        if(tail < head || (tail == head && queue[head]!=0)){
            System.arraycopy(queue, head, queue, head + 1, capacity - head -1);
            queue[head] = 0;
            head++;
        }
    }
    /*
        head 포인터의 원소를 삭제한다.
        null(여기에서는 0)인 경우가 아니라면
        원소를 뽑아내고 head 포인터를 한 칸 증가시킨다
     */
    static int removeFirst(){
        int x = queue[head];
        if(x!=0) {
            queue[head] = 0;
            head = inc(head, capacity);
        }
        return x;
    }

    /*
        tail 포인터에 있는 원소를 삭제한다

     */
    static int removeLast(){
        int x = queue[tail = dec(tail, capacity)];
        if(x!=0) {
            queue[tail] = 0;
        }
        return x;
    }
    /*
       큐에 끝에 포인터가 오면 포인터를 맨 왼쪽으로 옮기기
       ArrayDeque 클래스 참고
     */
    static final int inc(int i, int modulus){
        if(++i >= modulus) i=0;
        return i;
    }

    /*
       큐에 끝에 포인터가 오면 포인터를 맨 오른쪽으로 옮기기
     */
    static final int dec(int i, int modulus){
        if (--i < 0) i = modulus-1;
        return i;
    }
}
