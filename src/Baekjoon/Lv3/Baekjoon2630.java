package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2630 {

    static int[][] graph;
    static int num, countWhite, countBlue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        num = Integer.parseInt(br.readLine());

        graph = new int[num][num];

        countWhite = 0;
        countBlue = 0;

        for (int i = 0; i < num; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < num; j++) {
                graph[i][j] = Integer.parseInt(arr[j]);
            }
        }

        find(num, 0, 0);

        System.out.println(countWhite);
        System.out.println(countBlue);
        br.close();
    }

    private static void find(int size, int x, int y) {

        if (checkBoard(size, x, y)) {
            if (graph[y][x] == 1) {
                countBlue++;
            } else {
                countWhite++;
            }

            return;
        }

        find(size / 2, x, y);
        find(size / 2, x, y + size / 2);
        find(size / 2, x + size / 2, y);
        find(size / 2, x + size / 2, y + size / 2);
    }

    private static boolean checkBoard(int size, int x, int y) {
        int color = graph[y][x];

        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (graph[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }
}
