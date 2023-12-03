package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1012 {

    static Integer[][] graph;
    static boolean[] visited;
    static int count = 0;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        for (int i = 0; i < num; i++) {
            String[] arr = br.readLine().split(" ");
            graph = new Integer[Integer.parseInt(arr[0])][Integer.parseInt(arr[1])];
            visited = new boolean[Integer.parseInt(arr[2])];
            for (int j = 0; j < Integer.parseInt(arr[2]); j++) {
                String[] xy = br.readLine().split(" ");
                graph[Integer.parseInt(xy[0])][Integer.parseInt(xy[1])] = 1;
            }

            DFS(0);
            sb.append(count).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    public static void DFS(int x) {
        visited[x] = true;
        for (int i = 0; i < graph[x].length; i++) {
            if (!visited[graph[x][i]]){
                DFS(graph[x][i]);
            }
        }
    }
}
