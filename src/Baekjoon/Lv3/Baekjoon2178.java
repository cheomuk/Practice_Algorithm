package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon2178 {

    static int X, Y;
    static int[][] graph;
    static int[][] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        Y = Integer.parseInt(arr[0]);
        X = Integer.parseInt(arr[1]);

        graph = new int[Y + 1][X + 1];
        visited = new int[Y + 1][X + 1];

        for (int i = 0; i < Y; i++) {
            String[] xy = br.readLine().split("");
            for (int j = 0; j < X; j++) {
                graph[i][j] = Integer.parseInt(xy[j]);
                visited[i][j] = -1;
            }
        }

        bfs(0, 0);
        br.close();
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        int[] xy = new int[]{x, y};
        queue.add(xy);
        visited[y][x] = 1;

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        while(!queue.isEmpty()) {
            int[] node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int xn = node[0] + dx[i];
                int yn = node[1] + dy[i];

                if (yn >= 0 && xn >= 0) {
                    if (graph[yn][xn] == 1 && visited[yn][xn] == -1) {
                        visited[yn][xn] = visited[node[1]][node[0]] + 1;
                        queue.add(new int[]{xn, yn});
                    }
                }

                if (xn == X - 1 && yn == Y - 1) {
                    System.out.println(visited[yn][xn]);
                    return;
                }
            }
        }
    }
}
