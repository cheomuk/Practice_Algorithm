package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Baekjoon15486 {

    static int[] dp;
    static HashMap<Integer, int[]> map;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        dp = new int[num + 2];
        map = new HashMap<>();

        for (int i = 1; i <= num; i++) {
            String[] arr = br.readLine().split(" ");
            map.put(i, new int[] {Integer.parseInt(arr[0]), Integer.parseInt(arr[1])});
        }

        for (int i = 1; i <= num; i++) {
            int time = map.get(i)[0];
            int value = map.get(i)[1];

            if (i + time <= num + 1) {
                dp[i + time] = Math.max(dp[i + time], dp[i] + value);
                max = Math.max(max, dp[i + time]);
            }

            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
            max = Math.max(max, dp[i + 1]);
        }

        sb.append(max);

        System.out.println(sb);
        br.close();
    }
}
