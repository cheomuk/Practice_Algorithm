package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon1260 {

    static int N, M, V;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        N = Integer.parseInt(arr[0]);
        M = Integer.parseInt(arr[1]);
        V = Integer.parseInt(arr[2]);

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        sb = new StringBuilder();
        dfs(V);
        System.out.println(sb);

        sb = new StringBuilder();
        bfs(V);
        System.out.println(sb);

        br.close();
    }

    private static void dfs(int start) {
        visited[start] = true;
        sb.append(start).append(" ");

        for (int node : graph[start]) {
            if (!visited[node]) {
                dfs(node);
            }
        }
    }

    private static void bfs(int start) {
        visited = new boolean[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(" ");

            for (int next : graph[node]) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
