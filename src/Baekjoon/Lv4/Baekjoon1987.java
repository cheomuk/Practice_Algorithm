package Baekjoon.Lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Baekjoon1987 {

    static int R, C;
    static char[][] board;
    static boolean[][] visited;
    static int maxCount = 0;
    static HashSet<Character> set = new HashSet<>();
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");
        R = Integer.parseInt(str[0]);
        C = Integer.parseInt(str[1]);

        board = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        dfs(0, 0, 0);
        System.out.println(maxCount);
    }

    private static void dfs(int x, int y, int count) {
        if (!isValid(x, y) || visited[x][y] || set.contains(board[x][y])) {
            return;
        }

        visited[x][y] = true;
        set.add(board[x][y]);

        count = count + 1;
        maxCount = Math.max(maxCount, count);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            dfs(nx, ny, count);
        }

        // 백트래킹
        visited[x][y] = false;
        set.remove(board[x][y]);
    }

    private static boolean isValid(int x, int y) {
        return x >= 0 && x < R && y >= 0 && y < C;
    }
}
