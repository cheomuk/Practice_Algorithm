package Baekjoon.Lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon11725 {

    private static int n;
    private static int[] parent;
    private static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        parent = new int[n + 1];

        adj = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        bfs();

        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);

        boolean[] visited = new boolean[n + 1];
        visited[1] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int next : adj[node]) {
                if (visited[next]) {
                    continue;
                }

                visited[next] = true;
                queue.add(next);

                parent[next] = node;
            }
        }
    }
}
