package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11659 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] N = br.readLine().split(" ");
        String[] M = br.readLine().split(" ");

        int index = Integer.parseInt(N[0]);
        int repeat = Integer.parseInt(N[1]);

        dp = new int[index + 1];
        dp[0] = 0;

        for (int i = 1; i < M.length + 1; i++) {
            dp[i] = dp[i - 1] + Integer.parseInt(M[i - 1]);
        }

        for (int i = 1; i < repeat + 1; i++) {
            String[] arr = br.readLine().split(" ");
            sb.append(dp[Integer.parseInt(arr[1])] - dp[Integer.parseInt(arr[0]) - 1]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
