package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11660 {

    static int[][] graph;
    static int[][] dp;
    static int N, M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");
        N = Integer.parseInt(arr[0]);   // N x N
        M = Integer.parseInt(arr[1]);   // 합 조건 수

        graph = new int[N + 1][N + 1];
        dp = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            String[] arr2 = br.readLine().split(" ");
            for (int j = 1; j <= N; j++) {
                graph[i][j] = Integer.parseInt(arr2[j - 1]);
            }
        }

        setDp();

        for (int i = 1; i <= M; i++) {
            String[] arr3 = br.readLine().split(" ");

            int x1 = Integer.parseInt(arr3[0]);
            int y1 = Integer.parseInt(arr3[1]);
            int x2 = Integer.parseInt(arr3[2]);
            int y2 = Integer.parseInt(arr3[3]);

            int sum = dp[x2][y2] - dp[x2][y1 - 1] - dp[x1 - 1][y2] + dp[x1 - 1][y1 - 1];

            sb.append(sum).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static void setDp() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + graph[i][j];
            }
        }
    }
}
