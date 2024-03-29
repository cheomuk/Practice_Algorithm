package Baekjoon.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon15649 {

    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static int[] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        N = Integer.parseInt(arr[0]);
        M = Integer.parseInt(arr[1]);

        visited = new boolean[N];
        graph = new int[M];

        dfs(0);

        System.out.println(sb);
        br.close();
    }

    private static void dfs(int depth) {

        if (depth == M) {
            for (int val : graph) {
                sb.append(val).append(' ');
            }

            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                graph[depth] = i + 1;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
