package Baekjoon.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon9663 {

    static int N;
    static int count = 0;
    static int[][] graph;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        dfs(0);

        System.out.println(sb);
        br.close();
    }

    private static void dfs(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            graph[depth] = i;
            dfs(start, depth + 1);
            start++;
        }
    }
}
