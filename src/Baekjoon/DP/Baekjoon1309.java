package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1309 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N + 1][3];

        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        int condition = 9901;

        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % condition;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % condition;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % condition;
        }

        long ans = (dp[N][0] + dp[N][1] + dp[N][2]) % condition;

        sb.append(ans);

        System.out.println(sb);
        br.close();
    }
}
