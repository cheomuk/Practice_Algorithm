package Baekjoon.Lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon12865 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 물품의 수 N, 버틸 수 있는 무게 K
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] weights = new int[N + 1];
        int[] values = new int[N + 1];

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            weights[i] = Integer.parseInt(st.nextToken());
            values[i] = Integer.parseInt(st.nextToken());
        }

        // 최대 가치 계산
        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= K; w++) {
                if (weights[i] <= w) {
                    // i번째 물건을 배낭에 넣을 경우와 넣지 않을 경우 중 최대 가치 선택
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w-weights[i]] + values[i]);
                } else {
                    // i번째 물건을 배낭에 넣을 수 없는 경우
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println(dp[N][K]);
        br.close();
    }
}
