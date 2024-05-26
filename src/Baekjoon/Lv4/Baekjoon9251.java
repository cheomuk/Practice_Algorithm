package Baekjoon.Lv4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon9251 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        // 다이나믹 프로그래밍을 사용하여 LCS 길이 계산
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    // 문자가 같은 경우 대각선 왼쪽 위의 값에 1을 더함
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 문자가 다른 경우 왼쪽과 위쪽 중 더 큰 값 선택
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // dp 배열의 마지막 값이 LCS의 길이가 됨
        System.out.println(dp[str1.length()][str2.length()]);
        br.close();
    }
}
