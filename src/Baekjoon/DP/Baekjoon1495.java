package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1495 {

    static int N, S, M;

    static int[] VOLUME;

    static long[][] dp;

    public static void main(String[] args) throws Exception {
        input();
        executeByBottomUp();
    }

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 곡 수
        S = Integer.parseInt(st.nextToken()); // 시작 볼륨
        M = Integer.parseInt(st.nextToken()); // 최대 볼류

        VOLUME = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {
            VOLUME[i] = Integer.parseInt(st.nextToken());
        }

        dp = new long[N + 1][M + 1]; // [곡 순서][볼륨]
    }

    static void executeByBottomUp() {
        dp[0][S] = 1; //[시작][초기볼륨]

        for (int i = 1; i <= N; i++) { // 곡 순서
            for (int v = 0; v <= M; v++) { // 볼륨
                if (dp[i - 1][v] > 0) {
                    int v1 = v + VOLUME[i];
                    int v2 = v - VOLUME[i];

                    if (v1 <= M) {
                        dp[i][v1] += dp[i - 1][v];
                    }

                    if (v2 >= 0) {
                        dp[i][v2] += dp[i - 1][v];
                    }
                }
            }
        }

        int result = -1;

        for (int v = 0; v <= M; v++) {
            if (dp[N][v] > 0) {
                result = Math.max(result, v);
            }
        }

        System.out.println(result);
    }
}
