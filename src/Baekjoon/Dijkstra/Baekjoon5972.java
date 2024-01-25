package Baekjoon.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Baekjoon5972 {

    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Node>> graph;
    static int[] dp;

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

        graph = new ArrayList<>();
        dp = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            String[] arr2 = br.readLine().split(" ");

            int start = Integer.parseInt(arr2[0]);
            int end = Integer.parseInt(arr2[1]);
            int range = Integer.parseInt(arr2[2]);

            graph.get(start).add(new Node(end, range));
            graph.get(end).add(new Node(start, range));
        }

        Arrays.fill(dp, Integer.MAX_VALUE);

        bfs(1);

        sb.append(dp[N]);

        System.out.println(sb);
        br.close();
    }

    private static void bfs(int start) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(start, 0));

        dp[start] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (dp[node.value] < node.weight) {
                continue;
            }

            for (Node next : graph.get(node.value)) {
                if (dp[next.value] > dp[node.value] + next.weight) {
                    dp[next.value] = dp[node.value] + next.weight;
                    queue.add(new Node(next.value, dp[next.value]));
                }
            }
        }
    }
}
