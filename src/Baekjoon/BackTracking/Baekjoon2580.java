package Baekjoon.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Baekjoon2580 { // 미완성 코드

    static StringBuilder sb = new StringBuilder();
    static int[][] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        graph = new int[9][9];

        for (int i = 0; i < 9; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                graph[i][j] = Integer.parseInt(arr[j]);
            }
        }

        dfs(0);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(graph[i][j]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static void dfs(int depth) {

        if (depth == 9) {
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (graph[depth][i] == 0) {
                fill(i, depth);
            }
        }

        dfs(depth + 1);
    }

    private static void fill(int x, int y) {
        int dx = x / 3;
        int dy = y / 3;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < 9; i++) {
            set.add(i + 1);
        }

        for (int i = 0; i < 9; i++) {
            set.remove(graph[y][i]);
            set.remove(graph[i][x]);
            set.remove(graph[(3 * dy) + (i % 3)][(3 * dx) + (i % 3)]);
        }

        if (!set.isEmpty()) {
            graph[y][x] = set.iterator().next();
        }
    }
}
