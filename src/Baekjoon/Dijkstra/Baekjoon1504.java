package Baekjoon.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Baekjoon1504 {

    static StringBuilder sb = new StringBuilder();
    static ArrayList<ArrayList<Node>> graph;
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

        graph = new ArrayList<>();

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

        String[] quests = br.readLine().split(" ");
        int n1 = Integer.parseInt(quests[0]);
        int n2 = Integer.parseInt(quests[1]);

        // 1번 정점에서 v1 정점까지의 최단 거리
        int[] dist1 = bfs(1, N);

        // v1 정점에서 v2 정점까지의 최단 거리
        int[] dist2 = bfs(n1, N);

        // v2 정점에서 N번 정점까지의 최단 거리
        int[] dist3 = bfs(n2, N);

        // 1번 정점을 거쳐 v1 정점과 v2 정점을 반드시 지나는 최단 경로
        long result1 = dist1[n1] + dist2[n2] + dist3[N];

        // 1번 정점을 거쳐 v2 정점과 v1 정점을 반드시 지나는 최단 경로
        long result2 = dist1[n2] + dist3[n1] + dist2[N];

        // 최소 경로 저장
        long answer = (result1 >= INF && result2 >= INF) ? -1 : Math.min(result1, result2);

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

            for (Node next : graph.get(node.value)) {
                if (dp[next.value] > dp[node.value] + next.weight) {
                    dp[next.value] = dp[node.value] + next.weight;
                    queue.add(new Node(next.value, dp[next.value]));
                }
            }
        }

        return dp;
    }
}
