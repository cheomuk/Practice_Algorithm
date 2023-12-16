package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Baekjoon11399 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        ArrayList<Integer> list = new ArrayList<>();
        int sum = 0;
        dp = new int[num + 1];

        for (int i = 0; i < arr.length; i++) {
            list.add(Integer.parseInt(arr[i]));
        }

        Collections.sort(list);
        dp[0] = 0;

        for (int i = 1; i < list.size() + 1; i++) {
            dp[i] = dp[i - 1] + list.get(i - 1);
            sum += dp[i];
        }

        System.out.println(sum);
        br.close();
    }
}
