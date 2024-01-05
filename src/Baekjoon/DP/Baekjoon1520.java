package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1520 {

    static int N, M;
    static int[][] dp;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] arr = br.readLine().split(" ");

        N = Integer.parseInt(arr[0]);
        M = Integer.parseInt(arr[1]);

        dp = new int[N][M];
        graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] arr2 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(arr2[j]);
                dp[i][j] = -1;
            }
        }

        sb.append(dfs(0, 0));

        System.out.println(sb);
        br.close();
    }

    private static int dfs(int x, int y) {
        int[] dx = { 0, 0, 1, -1 };
        int[] dy = { 1, -1, 0, 0 };

        if (x == M - 1 && y == N - 1) {
            return 1;
        }

        if (dp[y][x] != -1) {
            return dp[y][x];
        } else {
            dp[y][x] = 0;

            for (int i = 0; i < 4; i++) {
                int xn = dx[i] + x;
                int yn = dy[i] + y;

                if (xn >= 0 && xn < M && yn >= 0 && yn < N) {
                    if (graph[yn][xn] < graph[y][x]) {
                        dp[y][x] += dfs(xn, yn);
                    }
                }
            }
        }

        return dp[y][x];
    }
}
