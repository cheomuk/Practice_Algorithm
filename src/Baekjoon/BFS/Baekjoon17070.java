package Baekjoon.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon17070 {

    static int[][] graph;
    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static class Pipe {
        int x, y, direction;

        public Pipe(final int x, final int y, final int direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(arr[j]);
            }
        }

        bfs(N);

        System.out.println(sb);
        br.close();
    }

    private static void bfs(int length) {
        Queue<Pipe> queue = new LinkedList<>();
        queue.add(new Pipe(1, 0, 1)); // x, y, direction

        while (!queue.isEmpty()) {
            Pipe node = queue.poll();

            int x = node.x;
            int y = node.y;
            int direction = node.direction;  // 1은 가로, 2는 세로, 3은 대각선

            // (N, N) 일 때 카운트
            if (x == length - 1 && y == length - 1) {
                count++;
            }

            // 가로 or 대각선 -> 가로
            if (direction == 1 || direction == 3) {
                if (x + 1 < length && graph[y][x + 1] != 1) {
                    queue.add(new Pipe(x + 1, y, 1));
                }
            }

            // 세로 or 대각선 -> 세로
            if (direction == 2 || direction == 3) {
                if (y + 1 < length && graph[y + 1][x] != 1) {
                    queue.add(new Pipe(x, y + 1, 2));
                }
            }

            // 대각선
            if (x + 1 < length && y + 1 < length) {
                if (graph[y + 1][x + 1] != 1 && graph[y][x + 1] != 1 && graph[y + 1][x] != 1) {
                    queue.add(new Pipe(x + 1, y + 1, 3));
                }
            }
        }

        sb.append(count);
    }
}
