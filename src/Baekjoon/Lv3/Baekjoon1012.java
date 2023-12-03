package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1012 {

    private static int M;

    private static int N;

    private static int[][] area;

    private static boolean[][] isVisit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] temp = br.readLine().split(" ");

            M = Integer.parseInt(temp[0]);
            N = Integer.parseInt(temp[1]);
            int K = Integer.parseInt(temp[2]);

            area = new int[M][N];
            isVisit = new boolean[M][N];
            int bugs = 0;

            for (int j = 0; j < K; j++) {
                temp = br.readLine().split(" ");

                int x = Integer.parseInt(temp[0]);
                int y = Integer.parseInt(temp[1]);

                area[x][y] = 1;
            }

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (area[x][y] == 1 && !isVisit[x][y]) {
                        bugs++;
                        dfs(x, y);
                    }
                }
            }

            System.out.println(bugs);
        }

        br.close();
    }

    private static void dfs(int x, int y) {
        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { -1, 1, 0, 0 };

        isVisit[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int xn = x + dx[i];
            int yn = y + dy[i];

            if ((xn > -1 && xn < M) && (yn > -1 && yn < N) && area[xn][yn] == 1 && !isVisit[xn][yn]) {
                dfs(xn, yn);
            }
        }
    }
}
