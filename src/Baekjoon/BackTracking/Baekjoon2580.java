package Baekjoon.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon2580 {

    static StringBuilder sb = new StringBuilder();
    static int[][] graph;
    static Stack<int[]> stack = new Stack<>();
    static boolean isSolved = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        graph = new int[9][9];

        for (int i = 0; i < 9; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < 9; j++) {
                graph[i][j] = Integer.parseInt(arr[j]);

                if (graph[i][j] == 0) {
                    stack.push(new int[]{i, j});
                }
            }
        }

        dfs();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(graph[i][j]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static void dfs() {

        if (stack.empty()) {
            isSolved = true;
            return;
        }

        int[] node = stack.pop();
        int x = node[1];
        int y = node[0];

        for (int i = 1; i <= 9; i++) {
            if (isValid(x, y, i)) {
                graph[y][x] = i;
                dfs();
                if (isSolved) {
                    return;
                }
                graph[y][x] = 0;
            }
        }

        stack.push(node);
    }

    private static boolean isValid(int x, int y, int value) {
        int dx = x / 3;
        int dy = y / 3;

        for (int i = 0; i < 9; i++) {
            if (graph[y][i] == value) {
                return false;
            }

            if (graph[i][x] == value) {
                return false;
            }

            if (graph[(3 * dy) + (i / 3)][(3 * dx) + (i % 3)] == value) {
                return false;
            }
        }

        return true;
    }
}
