package Algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class BOJ11725 {
    static int N;
    static Node[] nodes;
    static Queue<Integer> queue;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        N=Integer.parseInt(br.readLine());
        nodes=new Node[N+1];
        for (int i = 0; i < N-1; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            int vertex=Integer.parseInt(st.nextToken());
            int destination=Integer.parseInt(st.nextToken());

            // 앞 뒤 도착할 목적지에 다 노드 찍어주기.
            nodes[vertex]=new Node(destination, nodes[vertex]);
            nodes[destination]=new Node(vertex, nodes[destination]);
        }
        bfs();

        StringBuilder sb=new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(nodes[i].parent).append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs() {
        queue=new LinkedList<>();
        queue.offer(1);

        visited=new boolean[N+1];
        visited[1]=true;

        while(!queue.isEmpty()) {
            int current=queue.poll();

            for (Node tmp = nodes[current]; tmp != null; tmp = tmp.destination) {
                if(!visited[tmp.vertex]){
                    nodes[tmp.vertex].parent=current;
                    queue.offer(tmp.vertex);
                    visited[tmp.vertex]=true;
                }
            }
        }
    }

    static class Node{
        int vertex,parent;
        Node destination;

        Node(int vertex,Node destination){
            this.vertex=vertex;
            this.destination=destination;
        }
    }
}