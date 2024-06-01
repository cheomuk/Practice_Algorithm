package Baekjoon.Lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2096 {

    static int[][] min, max, graph;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        min = new int[N][3];
        max = new int[N][3];
        graph = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution();

        int min_value = Integer.MAX_VALUE;
        int max_value = 0;

        for (int i = 0; i < 3; i++) {
            min_value = Math.min(min_value, min[N - 1][i]);
            max_value = Math.max(max_value, max[N - 1][i]);
        }

        sb.append(max_value).append(" ").append(min_value);

        System.out.println(sb);
        br.close();
    }

    private static void solution() {
        for (int i = 0; i < 3; i++) {
            min[0][i] = graph[0][i];
            max[0][i] = graph[0][i];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 0) {
                    min[i][j] = Math.min(graph[i][j] + min[i - 1][j + 1], graph[i][j] + min[i - 1][j]);
                    max[i][j] = Math.max(graph[i][j] + max[i - 1][j + 1], graph[i][j] + max[i - 1][j]);
                }

                if (j == 1) {
                    min[i][j] = Math.min(Math.min(graph[i][j] + min[i - 1][j - 1], graph[i][j] + min[i - 1][j]),
                            graph[i][j] + min[i - 1][j + 1]);
                    max[i][j] = Math.max(Math.max(graph[i][j] + max[i - 1][j - 1], graph[i][j] + max[i - 1][j]),
                            graph[i][j] + max[i - 1][j + 1]);
                }

                if (j == 2) {
                    min[i][j] = Math.min(graph[i][j] + min[i - 1][j - 1], graph[i][j] + min[i - 1][j]);
                    max[i][j] = Math.max(graph[i][j] + max[i - 1][j - 1], graph[i][j] + max[i - 1][j]);
                }
            }
        }
    }
}
