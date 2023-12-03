package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1003 {

    static Integer[][] dp = new Integer[41][2];

    public static void main(String[] args) throws IOException { // 다시 복습해야 할 문제!!

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        dp[0][0] = 1;	// params = 0 일 때의 0 호출 횟수
        dp[0][1] = 0;	// params = 0 일 때의 1 호출 횟수
        dp[1][0] = 0;	// params = 1 일 때의 0 호출 횟수
        dp[1][1] = 1;	// params = 1 일 때의 1 호출 횟수

        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            int params = Integer.parseInt(br.readLine());
            Integer[] value = fibo(params);
            sb.append(dp[params][0]).append(" ").append(dp[params][1]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static Integer[] fibo(int params) {
        if (dp[params][0] == null || dp[params][1] == null) {
            dp[params][0] = fibo(params - 2)[0] + fibo(params - 1)[0];
            dp[params][1] = fibo(params - 2)[1] + fibo(params - 1)[1];
        }

        return dp[params];
    }
}
