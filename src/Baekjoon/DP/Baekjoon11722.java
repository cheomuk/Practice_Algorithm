package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon11722 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        int[] list = new int[num];
        dp = new int[num];

        for (int i = 0; i < num; i++) {
            list[i] = Integer.parseInt(arr[i]);
        }

        dp[0] = 1;

        for (int i = 1; i < num; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (list[i] < list[j]) {
                    max = Math.max(dp[j], max);
                }
            }

            dp[i] = max + 1;
        }

        Arrays.sort(dp);
        sb.append(dp[num - 1]).append("\n");

        System.out.println(sb);
        br.close();
    }
}
