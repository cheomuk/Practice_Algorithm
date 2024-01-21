package Baekjoon.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baekjoon1446 {

    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[][] graph;
    static int[][] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        N = Integer.parseInt(arr[0]);
        M = Integer.parseInt(arr[1]);

        graph = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            String[] arr2 = br.readLine().split(" ");
            for (int j = 0; j < arr2.length; j++) {
                graph[i][j] = Integer.parseInt(arr2[j]);
            }
        }

        bfs(graph[0][0]);

        System.out.println(sb);
        br.close();
    }

    private static void bfs(int start) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(start);

        while (!pq.isEmpty()) {
            int node = pq.poll();

            for (int i = 0; i < graph.length; i++) {
                if (node < M && graph[i][0] == node) {
                    pq.add(graph[i][1]);
                    dp[i][2] = Math.min(dp[i - 1][2], graph[i][2]);
                }
            }
        }
    }
}
