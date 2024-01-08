package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon11049 {

    static int[][] dp;
    static int[][] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        graph = new int[num][2];
        dp = new int[500][500];

        for (int i = 0; i < num; i++) {
            String[] arr = br.readLine().split(" ");

            graph[i][0] = Integer.parseInt(arr[0]);
            graph[i][1] = Integer.parseInt(arr[1]);
        }

        sb.append(find()).append("\n");

        System.out.println(sb);
        br.close();
    }

    private static int find() {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < graph.length; i++) {
            for ()
        }

        return min;
    }
}
