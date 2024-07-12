package Programmers.Lv2;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortestDistance {
    public int solution(int[][] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            if (x == n - 1 && y == m - 1) {
                answer = maps[x][y];
                break;
            }

            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (newX >= 0 && newX < n && newY >= 0 && newY < m && maps[newX][newY] == 1 && !visited[newX][newY]) {
                    queue.offer(new int[]{newX, newY});
                    visited[newX][newY] = true;
                    maps[newX][newY] = maps[x][y] + 1;
                }
            }
        }

        if (answer == 0) {
            return -1;
        }

        return answer;
    }
}
