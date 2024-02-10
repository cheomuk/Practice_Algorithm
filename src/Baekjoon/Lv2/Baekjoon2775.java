package Baekjoon.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2775 {

    public static int[][] graph = new int[15][15];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        find();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());
            sb.append(graph[K][N]).append('\n');
        }
        System.out.println(sb);
    }


    public static void find() {

        for (int i = 0; i < 15; i++) {
            graph[i][1] = 1;
            graph[0][i] = i;
        }

        for (int i = 1; i < 15; i++) {

            for (int j = 2; j < 15; j++) {
                graph[i][j] = graph[i][j - 1] + graph[i - 1][j];
            }
        }
    }
}
