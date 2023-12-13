package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon7569 {

    static int[][][] graph;
    static int[][][] visited;
    static int M, N, H;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        Queue<int[]> queue = new LinkedList<>();

        M = Integer.parseInt(arr[0]);
        N = Integer.parseInt(arr[1]);
        H = Integer.parseInt(arr[2]);

        graph = new int[H][M][N];
        visited = new int[H][M][N];

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                String[] arr2 = br.readLine().split(" ");
                for (int q = 0; q < M; q++) {
                    graph[i][q][j] = Integer.parseInt(arr2[q]);
                    visited[i][q][j] = -1;

                    if (graph[i][q][j] == 1) {
                        queue.add(new int[]{q, j, i});
                        visited[i][q][j] = 0;
                    }
                }
            }
        }

        bfs(queue);
        checkTomato();

        System.out.println(count);
        br.close();
    }

    private static void bfs(Queue<int[]> queue) {
        int[] dx = { 0, 0, -1, 1, 0, 0 };
        int[] dy = { -1, 1, 0, 0, 0, 0 };
        int[] dz = { 0, 0, 0, 0, -1, 1 };

        while(!queue.isEmpty()) {
            int[] node = queue.poll();

            for (int i = 0; i < 6; i++) {
                int xn = dx[i] + node[0];
                int yn = dy[i] + node[1];
                int zn = dz[i] + node[2];

                if (yn >= 0 && xn >= 0 && yn < N && xn < M && zn >= 0 && zn < H) {
                    if (graph[zn][xn][yn] == 0 && visited[zn][xn][yn] == -1) {
                        graph[zn][xn][yn] = 1;
                        visited[zn][xn][yn] = visited[node[2]][node[0]][node[1]] + 1;
                        count = visited[zn][xn][yn];
                        queue.add(new int[]{xn, yn, zn});
                    }
                }
            }
        }
    }

    private static void checkTomato() {
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int q = 0; q < M; q++) {
                    if (graph[i][q][j] == 0) {
                        count = -1;
                        return;
                    }
                }
            }
        }
    }
}
