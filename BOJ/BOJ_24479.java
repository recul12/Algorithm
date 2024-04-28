package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class BOJ_24479 {
    /*
    오늘도 서준이는 깊이 우선 탐색(DFS) 수업 조교를 하고 있다. 수업한 내용을 학생들이 잘 이해했는지 문제를 통해서 확인해보자.

    N개의 정점과 M개의 간선으로 구성된 무방향 그래프가 주어진다. 정점 번호는 1번부터 N번, 모든 간선의 가중치는 1이다.
    정점 R에서 시작하여 깊이 우선 탐색으로 노드를 방문할 경우 노드의 방문 순서를 출력하자.
    깊이 우선 탐색 의사 코드는 다음과 같다. 인접 정점은 오름차순으로 방문한다.

    dfs(V, E, R) {  # V : 정점 집합, E : 간선 집합, R : 시작 정점
        visited[R] <- YES;  # 시작 정점 R을 방문 했다고 표시한다.
        for each x ∈ E(R)  # E(R) : 정점 R의 인접 정점 집합.(정점 번호를 오름차순으로 방문한다)
            if (visited[x] = NO) then dfs(V, E, x);
    }
     */
    static ArrayList<Integer> graph[];
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken()); // 정점의 수
        int M = Integer.parseInt(st.nextToken()); // 간선의 수
        int R = Integer.parseInt(st.nextToken()); // 시작 정점

        int order[] = new int[N+1];

        graph = new ArrayList[N+1];

        for (int i = 0; i < N; i++) {
            graph[i+1] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from].add(to);
            graph[to].add(from);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        count = 1;
        DFS(R, order);

        for (int i = 1; i <= N; i++) {
            sb.append(order[i]).append("\n");
        }
        System.out.println(sb);
    }

    private static void DFS(int current, int[] order) {
        order[current] = count;

        for (int i = 0; i < graph[current].size(); i++) {
            int tmp = graph[current].get(i);
            if(order[tmp] == 0) {
                count++;
                DFS(tmp, order);
            }
        }
    }
}
