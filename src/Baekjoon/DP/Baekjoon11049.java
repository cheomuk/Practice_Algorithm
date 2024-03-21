package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon11049 {

    static int[][] dp;
    static int[][] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        graph = new int[n][2];
        dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            graph[i][0] = Integer.parseInt(input[0]);
            graph[i][1] = Integer.parseInt(input[1]);
        }

        sb.append(find(0, n - 1)).append("\n");

        System.out.println(sb);
        br.close();
    }

    private static int find(int start, int end) {
        if (start == end) {
            return 0;
        }

        if (dp[start][end] != 0) {
            return dp[start][end];
        }

        int min = Integer.MAX_VALUE;

        for (int i = start; i < end; i++) {
            int cost = find(start, i) + find(i + 1, end) + graph[start][0] * graph[i][1] * graph[end][1];
            min = Math.min(min, cost);
        }

        dp[start][end] = min;

        return min;
    }
}
