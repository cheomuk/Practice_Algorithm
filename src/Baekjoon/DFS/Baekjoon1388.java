package Baekjoon.DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon1388 {

    static int N, M;
    static char[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        int cnt = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(visited[i][j]) {
                    continue;
                }

                if(arr[i][j] == '-') {
                    dfs(i, j, true);
                } else {
                    dfs(i, j, false);
                }

                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static void dfs(int i, int j, boolean row) {
        visited[i][j] = true;

        if (row) {
            j++;
            if (j < M && arr[i][j] == '-') {
                dfs(i, j, true);
            }
        } else {
            i++;
            if (i < N && arr[i][j] != '-') {
                dfs(i, j, false);
            }
        }
    }
}
