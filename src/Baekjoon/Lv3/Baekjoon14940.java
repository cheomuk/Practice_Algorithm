package Baekjoon.Lv3;

import java.io.*;
import java.util.*;

public class Baekjoon14940 {
    static int n, m;
    static int map[][];
    static int sx, sy;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    sx = i;
                    sy = j;
                }
            }
        }

        bfs();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] > 0) {
                    sb.append(map[i][j] - 2 + " ");
                } else {
                    sb.append(0 + " ");
                }
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs() {
        int[] dr = {0, 0, -1, 1};
        int[] dc = {-1, 1, 0, 0};

        Queue<point> queue = new LinkedList<>();
        queue.add(new point(sx, sy));

        map[sx][sy] = 2;

        while (!queue.isEmpty()) {
            point p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = p.x + dr[i];
                int ny = p.y + dc[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || map[nx][ny] == 0) {
                    continue;
                }

                if (map[nx][ny] == 1) {
                    map[nx][ny] = map[p.x][p.y] + 1;
                    queue.offer(new point(nx, ny));
                }
            }
        }
    }

    static class point {
        int x;
        int y;

        public point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
