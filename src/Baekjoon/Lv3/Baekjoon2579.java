package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2579 {

    static Integer[] dp;
    static int[] arr;

    public static void main(String[] args) throws IOException { // 다이나믹 프로그램이 - 다시 풀어보기!!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        dp = new Integer[num + 1];
        arr = new int[num + 1];

        for (int i = 1; i <= num; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = arr[0];
        dp[1] = arr[1];

        if (num >= 2) {
            dp[2] = arr[1] + arr[2];
        }

        System.out.println(find(num));
        br.close();
    }

    private static int find(int num) {
        if(dp[num] == null) {
            dp[num] = Math.max(find(num - 2), find(num - 3) + arr[num - 1]) + arr[num];
        }

        return dp[num];
    }
}
