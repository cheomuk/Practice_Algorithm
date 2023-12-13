package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon7576 {

    static int[][] graph;
    static int[][] visited;
    static int M, N;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        Queue<int[]> queue = new LinkedList<>();

        M = Integer.parseInt(arr[0]);
        N = Integer.parseInt(arr[1]);

        graph = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] arr2 = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(arr2[j]);
                visited[i][j] = -1;

                if (graph[i][j] == 1) {
                    queue.add(new int[]{j, i});
                    visited[i][j] = 0;
                }
            }
        }

        bfs(queue);
        checkTomato();

        System.out.println(count);
        br.close();
    }

    private static void bfs(Queue<int[]> queue) {
        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { -1, 1, 0, 0 };

        while(!queue.isEmpty()) {
            int[] node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int xn = dx[i] + node[0];
                int yn = dy[i] + node[1];

                if (yn >= 0 && xn >= 0 && yn < N && xn < M) {
                    if (graph[yn][xn] == 0 && visited[yn][xn] == -1) {
                        graph[yn][xn] = 1;
                        visited[yn][xn] = visited[node[1]][node[0]] + 1;
                        count = visited[yn][xn];
                        queue.add(new int[]{xn, yn});
                    }
                }
            }
        }
    }

    private static void checkTomato() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    count = -1;
                    return;
                }
            }
        }
    }
}
