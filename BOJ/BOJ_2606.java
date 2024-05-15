package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_2606 {
    /*
        신종 바이러스인 웜 바이러스는 네트워크를 통해 전파된다.
        한 컴퓨터가 웜 바이러스에 걸리면 그 컴퓨터와 네트워크 상에서 연결되어 있는 모든 컴퓨터는 웜 바이러스에 걸리게 된다.

        네트워크 연결이 되어 있지 않으면 영향을 받지 않을 때, 1번 컴퓨터가 바이러스에 걸렸으면 그를 통해 바이러스에 감염되는
        컴퓨터의 수를 구하라.
     */
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int E = Integer.parseInt(br.readLine());

        List<Integer>[] list = new List[N+1];

        for (int i = 1; i < N+1; i++) {
            list[i] = new ArrayList();
        }

        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            list[from].add(to);
            list[to].add(from);
        }
        count = 0;

        int[] visited = new int[N+1];

        DFS(1, visited, list);

        System.out.println(count);
    }

    static void DFS(int current, int[] visited, List<Integer>[] list){
        visited[current] = 1;

        for (int i = 0; i < list[current].size(); i++) {
            int tmp = list[current].get(i);
            if(visited[tmp] == 0){
                count++;
                DFS(tmp, visited, list);
            }
        }
    }
}
