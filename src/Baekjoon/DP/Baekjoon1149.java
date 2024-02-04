package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Baekjoon1149 {

    final static int red = 0;
    final static int green = 1;
    final static int blue = 2;

    static int[][] costs;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        costs = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");

            costs[i][red] = Integer.parseInt(arr[0]);
            costs[i][green] = Integer.parseInt(arr[1]);
            costs[i][blue] = Integer.parseInt(arr[2]);
        }

        dp[0][red] = costs[0][red];
        dp[0][green] = costs[0][green];
        dp[0][blue] = costs[0][blue];

        int min = Math.min(find(N- 1, red), Math.min(find(N - 1, green), find(N - 1, blue)));

        sb.append(min);

        System.out.println(sb);
        br.close();
    }

    private static int find(int N, int color) {

        if (dp[N][color] == 0) {
            if (color == red) {
                dp[N][red] = Math.min(find(N - 1, green), find(N - 1, blue)) + costs[N][red];
            } else if (color == green) {
                dp[N][green] = Math.min(find(N - 1, red), find(N - 1, blue)) + costs[N][green];
            } else {
                dp[N][blue] = Math.min(find(N - 1, red), find(N - 1, green)) + costs[N][blue];
            }
        }

        return dp[N][color];
    }
}
