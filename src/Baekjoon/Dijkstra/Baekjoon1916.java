package Baekjoon.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1916 {

    static StringBuilder sb = new StringBuilder();
    static int[][] graph;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] rangeArr = new int[M + 1];
        graph = new int[N + 1][N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < M; i++) {
            String[] arr = br.readLine().split(" ");

            int start = Integer.parseInt(arr[0]);
            int end = Integer.parseInt(arr[1]);
            int range = Integer.parseInt(arr[2]);

            if (graph[start][end] > range) {
                graph[start][end] = range;
            }
        }

        String[] arr = br.readLine().split(" ");
        rangeArr[0] = Integer.parseInt(arr[0]);
        rangeArr[1] = Integer.parseInt(arr[1]);

        Arrays.fill(dp, Integer.MAX_VALUE);

        bfs(rangeArr[0], rangeArr[1]);

        System.out.println(sb);
        br.close();
    }

    private static void bfs(int start, int end) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(start);

        dp[start] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int next = 1; next < graph[node].length; next++) {
                if (graph[node][next] != Integer.MAX_VALUE && dp[next] > dp[node] + graph[node][next]) {
                    dp[next] = dp[node] + graph[node][next];
                    queue.add(next);
                }
            }
        }


        sb.append(dp[end]);
    }
}
