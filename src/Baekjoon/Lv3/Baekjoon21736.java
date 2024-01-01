package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon21736 {

    static int N, M;
    static String[][] graph;
    static boolean[][] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] arr = br.readLine().split(" ");
        int[] saveLocate = new int[2];

        N = Integer.parseInt(arr[0]);
        M = Integer.parseInt(arr[1]);

        graph = new String[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] arr2 = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                if (arr2[j].equals("I")) {
                    saveLocate = new int[]{i, j};
                }

                graph[i][j] = arr2[j];
            }
        }

        bfs(saveLocate[1], saveLocate[0]);

        if (count == 0) {
            sb.append("TT");
        } else {
            sb.append(count);
        }

        System.out.println(sb);
        br.close();
    }

    private static void bfs(int x, int y) {
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[y][x] = true;

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int xn = dx[i] + node[0];
                int yn = dy[i] + node[1];

                if (xn >= 0 && xn < M && yn >= 0 && yn < N) {
                    if (!visited[yn][xn] && !graph[yn][xn].equals("X")) {
                        queue.add(new int[]{xn, yn});
                        visited[yn][xn] = true;

                        if (graph[yn][xn].equals("P")) {
                            count++;
                        }
                    }
                }
            }
        }
    }
}
