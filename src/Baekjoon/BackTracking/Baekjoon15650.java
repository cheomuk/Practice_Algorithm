package Baekjoon.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon15650 {

    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static int[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        N = Integer.parseInt(arr[0]);
        M = Integer.parseInt(arr[1]);

        graph = new int[M];

        dfs(1, 0);

        System.out.println(sb);
        br.close();
    }

    private static void dfs(int start, int depth) {

        if (depth == M) {
            for (int val : graph) {
                sb.append(val).append(' ');
            }

            sb.append('\n');
            return;
        }

        for (int i = start; i <= N; i++) {
            graph[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }
}
