package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baekjoon2630 {

    static int[][] graph;
    static boolean[][] visited;
    static int num, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        num = Integer.parseInt(br.readLine());

        graph = new int[num][num];
        visited = new boolean[num][num];
        count = 0;

        for (int i = 0; i < num; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < num; j++) {
                graph[i][j] = Integer.parseInt(arr[j]);
            }
        }

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (graph[i][j] == 1 && !visited[i][j]) {
                    find((int) Math.pow(num, 2), j, i);
                }
            }
        }

        br.close();
    }

    private static void find(int size, int x, int y) {
        if (x < size / 2 && y < size / 2) {
            find(size / 2, x, y);
        } else if (x < size / 2 && y >= size / 2) {
            count += size * size / 4;
            find(size / 2, x, y - size / 2);
        } else if (x >= size / 2 && y < size / 2) {
            count += (size * size / 4) * 2;
            find(size / 2, x - size / 2, y);
        } else {
            count += (size * size / 4) * 3;
            find(size / 2, x - size / 2, y - size / 2);
        }
    }
}
