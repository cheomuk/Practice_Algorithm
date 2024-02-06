package Baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon1783 {

    static int N, M;
    static int[][] graph;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] arr = br.readLine().split(" ");
        N = Integer.parseInt(arr[0]);
        M = Integer.parseInt(arr[1]);

        graph = new int[N][M];



        System.out.println(sb);
        br.close();
    }
}
