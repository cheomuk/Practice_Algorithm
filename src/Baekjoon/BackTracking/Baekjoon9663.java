package Baekjoon.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon9663 {

    static int N;
    static int count = 0;
    static int[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        visited = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                visited[i][j] = -1;
            }
        }

        dfs(0);
        sb.append(count).append("\n");

        System.out.println(sb);
        br.close();
    }

    private static void dfs(int depth) {
        if (depth == N) {
            count++;
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[depth][i] == -1) {
                visited[depth][i] = 0;
                fill(i, depth, 1);

                dfs(depth + 1);

                fill(i, depth, -1);
                visited[depth][i] = -1;
            }
        }
    }

    private static void fill(int x, int y, int value) {
        for (int i = 0; i < N; i++) {

            // 상하
            if (i != y) {
                visited[i][x] += value;
            }

            // 좌우
            if (i != x) {
                visited[y][i] += value;
            }

            // 대각선 - 4시 방향
            if (y + i < N && x + i < N) {
                visited[y + i][x + i] += value;
            }

            // 대각선 - 10시 방향
            if (y - i >= 0 && x - i >= 0) {
                visited[y - i][x - i] += value;
            }

            // 대각선 - 7시 방향
            if (y + i < N && x - i >= 0) {
                visited[y + i][x - i] += value;
            }

            // 대각선 - 2시 방향
            if (y - i >= 0 && x + i < N) {
                visited[y - i][x + i] += value;
            }
        }
    }
}
