package Baekjoon.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1753 {

    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Node>> graph;
    static int[] dp;

    static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
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

        int V = Integer.parseInt(arr[0]);
        int E = Integer.parseInt(arr[1]);
        int K = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        dp = new int[V + 1];

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            String[] arr2 = br.readLine().split(" ");

            int start = Integer.parseInt(arr2[0]);
            int end = Integer.parseInt(arr2[1]);
            int range = Integer.parseInt(arr2[2]);

            graph.get(start).add(new Node(end, range));
        }

        Arrays.fill(dp, Integer.MAX_VALUE);

        bfs(K);

        for (int i = 1; i <= V; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(dp[i]).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    private static void bfs(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        dp[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (dp[node.end] < node.weight) {
                continue;
            }

            for (Node next : graph.get(node.end)) {
                if (dp[next.end] > dp[node.end] + next.weight) {
                    dp[next.end] = dp[node.end] + next.weight;
                    queue.add(new Node(next.end, dp[next.end]));
                }
            }
        }
    }
}
