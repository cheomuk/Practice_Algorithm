package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Baekjoon16928 {

    static int N, M;
    static HashMap<Integer, Integer> graph = new HashMap<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] arr = br.readLine().split(" ");

        N = Integer.parseInt(arr[0]);
        M = Integer.parseInt(arr[1]);

        visited = new int[100];

        for (int i = 0; i < N; i++) {
            String[] arr2 = br.readLine().split("");
            graph.put(Integer.parseInt(arr2[0]), Integer.parseInt(arr2[1]));
        }

        find(1);
        sb.append(visited[100]);

        System.out.println(sb);
        br.close();
    }

    private static void find(int start) {

    }
}
