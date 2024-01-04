package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Baekjoon15486 {

    static int[] dp;
    static HashMap<Integer, int[]> map;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        dp = new int[num + 1];
        map = new HashMap<>();

        for (int i = 1; i <= num; i++) {
            String[] arr = br.readLine().split(" ");
            map.put(i, new int[] {Integer.parseInt(arr[0]), Integer.parseInt(arr[1])});
        }

        find(num);

        sb.append(max);

        System.out.println(sb);
        br.close();
    }

    private static int find(int end) {
        int time = 0;
        for (int i = 1; i <= end; i++) {
            if (time == 0 && i + map.get(i)[0] <= end + 1) {
                dp[i] = dp[i - 1] + map.get(i)[1];
                time += map.get(i)[0];
            } else {
                dp[i] = dp[i - 1];
            }

            time--;
        }

        Arrays.sort(dp);
        max = Math.max(dp[end], max);

        return max;
    }
}
