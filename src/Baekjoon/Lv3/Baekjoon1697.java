package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1697 { // 반례 찾는 중

    static int[] dp;
    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        int start = Integer.parseInt(arr[0]);
        int end = Integer.parseInt(arr[1]);

        dp = new int[start + end + 2];
        dp[start] = 0;
        dp[end] = end;

        find(start, end);

        System.out.println(sb.append(count));
        br.close();
    }

    private static void find(int start, int end) {

        if (dp[end] - 1 == start || dp[end] + 1 == start) {
            count++;
            return;
        } else if (dp[start] == start) {
            return;
        } else if (dp[end] % 2 == 0 && dp[end] > start) {
            dp[end / 2] = dp[end] / 2;
            count++;
            find(start, end / 2);
        } else if (dp[end] % 2 == 0 && dp[end] * 2 < start) {
            dp[end * 2] = dp[end] * 2;
            count++;
            find(start, end * 2);
        } else if (dp[end] < start) {
            dp[end + 1] = dp[end] + 1;
            count++;
            find(start, end + 1);
        } else {
            dp[end - 1] = dp[end] - 1;
            count++;
            find(start, end - 1);
        }
    }
}
