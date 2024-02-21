package Baekjoon.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon1679 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        String[] arr = br.readLine().split(" ");
        int maxA = 0;

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(arr[i]);
            maxA = Math.max(maxA, A[i]);
        }

        int K = Integer.parseInt(br.readLine());
        int[] memo = new int[maxA * K + 1 + 1];

        for (int i = 1; i < memo.length; i++) {
            memo[i] = Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                if (A[j] <= i) {
                    memo[i] = Math.min(memo[i], memo[i - A[j]] + 1);
                }
            }

            if (memo[i] > K) {
                if (i % 2 == 0) {
                    sb.append("holsoon");
                } else {
                    sb.append("jjaksoon");
                }

                sb.append(" win at ");
                sb.append(i);

                System.out.println(sb);
                return;
            }
        }
    }
}
