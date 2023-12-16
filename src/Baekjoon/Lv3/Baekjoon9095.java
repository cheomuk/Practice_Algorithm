package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon9095 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        dp = new int[11];

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 0; i < num; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(find(n)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static int find(int num) {
        if (num == 1) {
            return 1;
        } else if (num == 2) {
            return 2;
        } else if (num == 3) {
            return 4;
        } else {
            dp[num] = find(num - 1) + find(num - 2) + find(num - 3);
        }

        return dp[num];
    }
}
