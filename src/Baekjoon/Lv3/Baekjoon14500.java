package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon14500 {

    static int[][] graph;
    static boolean[][] visited;
    static int count = 0;
    static int N, M;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] arr = br.readLine().split(" ");

        N = Integer.parseInt(arr[0]);   // y
        M = Integer.parseInt(arr[1]);   // x

        graph = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] arr2 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(arr2[j]);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                find(j, i, graph[i][j], 0);
                visited[i][j] = false;
            }
        }

        sb.append(max);

        System.out.println(sb);
        br.close();
    }

    private static void find(int x, int y, int value, int count) {
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        if (count == 3) {
            max = Math.max(value, max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int xn = dx[i] + x;
            int yn = dy[i] + y;

            if(xn < 0 || xn >= N || yn < 0 || yn >= M) {
                continue;
            }

            if (!visited[yn][xn]) {
                if (count == 1) {
                    visited[yn][xn] = true;
                    find(x, y, value + graph[yn][xn], count + 1);
                    visited[yn][xn] = false;
                }

                visited[yn][xn] = true;
                find(xn, yn, value + graph[yn][xn], count + 1);
                visited[yn][xn] = false;
            }
        }
    }
}
