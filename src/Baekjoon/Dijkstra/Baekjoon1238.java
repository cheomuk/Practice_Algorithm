package Baekjoon.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Baekjoon1238 {

    static StringBuilder sb = new StringBuilder();
    static ArrayList<Node>[] graph;
    private static int INF = 200000000;

    static class Node implements Comparable<Node> {
        int value;
        int weight;

        public Node(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node node) {
            return this.weight - node.weight;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);
        int X = Integer.parseInt(arr[2]);

        graph = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            String[] arr2 = br.readLine().split(" ");

            int start = Integer.parseInt(arr2[0]);
            int end = Integer.parseInt(arr2[1]);
            int range = Integer.parseInt(arr2[2]);

            graph[start].add(new Node(end, range));
        }

        long answer = 0;

        for (int i = 1; i <= N; i++) {
            int[] dist1 = bfs(i, N);
            int[] dist2 = bfs(X, N);
            answer = Math.max(dist1[X] + dist2[i], answer);
        }

        sb.append(answer).append("\n");

        System.out.println(sb);
        br.close();
    }

    private static int[] bfs(int start, int end) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        int[] dp = new int[end + 1];
        Arrays.fill(dp, INF);

        dp[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (dp[node.value] < node.weight) {
                continue;
            }

            for (Node next : graph[node.value]) {
                if (dp[next.value] > dp[node.value] + next.weight) {
                    dp[next.value] = dp[node.value] + next.weight;
                    queue.add(new Node(next.value, dp[next.value]));
                }
            }
        }

        return dp;
    }
}
