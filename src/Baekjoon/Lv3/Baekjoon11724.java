package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon11724 {

    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int N, M;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        N = Integer.parseInt(arr[0]);   // 정점 개수
        M = Integer.parseInt(arr[1]);   // 간선 개수

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] strArr = br.readLine().split(" ");
            int u = Integer.parseInt(strArr[0]);
            int v = Integer.parseInt(strArr[1]);

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                bfs(i);
            }
        }

        System.out.println(count);
        br.close();
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int next : graph[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }

        count++;
    }
}
