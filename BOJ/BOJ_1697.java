package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_1697 {
    static int N,K,answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 수빈이의 위치 N, 동생의 위치 K
        N= Integer.parseInt(st.nextToken());
        K= Integer.parseInt(st.nextToken());

        // 너비 우선 탐색으로 수빈이를 동생에게 보낸다.
        bfs();

        System.out.println(answer);
    }

    private static void bfs(){
        // 방문했는지 체크하기 위한
        int[] visit = new int[100001];
        // 큐 생성
        Queue<int[]> queue = new LinkedList<>();
        // 현재 수빈이의 위치를 queue에 넣는다
        queue.add(new int[]{N,0});
        // 수빈이의 위치 방문표시
        visit[N]=1;
        // BFS 시작
        while(!queue.isEmpty()){
            int num = queue.peek()[0];
            int depth = queue.poll()[1];

            if (num == K) {
                answer = depth;
                break;
            }

            int tmp[] = new int[3];

            tmp[0] = num - 1;
            tmp[1] = num + 1;
            tmp[2] = num * 2;

            for (int i = 0; i < 3; i++) {
                if (tmp[i] < 0 || tmp[i] > 100000 || visit[tmp[i]]!=0) continue;
                visit[tmp[i]]=1;
                queue.offer(new int[]{tmp[i],depth+1});
            }
        }
    }
}
