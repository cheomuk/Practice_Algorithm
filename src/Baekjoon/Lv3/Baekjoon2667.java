package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2667 {

    static int[][] graph;
    static boolean[][] visited;
    static int num, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        num = Integer.parseInt(br.readLine());

        graph = new int[num][num];
        visited = new boolean[num][num];
        count = 1;

        for (int i = 0; i < num; i++) {
            String[] arr = br.readLine().split("");
            for (int j = 0; j < num; j++) {
                graph[i][j] = Integer.parseInt(arr[j]);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    dfs(j, i);
                    list.add(count);
                    count = 1;
                }
            }
        }

        Collections.sort(list);
        sb.append(list.size()).append("\n");

        for (int i : list) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static void dfs(int x, int y) {
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };

        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int xn = x + dx[i];
            int yn = y + dy[i];

            if ((xn >= 0 && xn < num) && (yn >= 0 && yn < num) && graph[yn][xn] == 1 && !visited[yn][xn]) {
                count++;
                dfs(xn, yn);
            }
        }
    }
}
