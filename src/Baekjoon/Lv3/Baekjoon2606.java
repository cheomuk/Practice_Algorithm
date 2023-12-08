package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2606 {

    static ArrayList<Integer>[] graph;
    static int[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());

        graph = new ArrayList[num1 + 1];
        visited = new int[num1 + 1];

        Arrays.fill(visited, -1);
        for (int i = 1; i <= num1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= num2; i++) {
            String[] arr = br.readLine().split(" ");
            int u = Integer.parseInt(arr[0]);
            int v = Integer.parseInt(arr[1]);

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= num1; i++) {
            Collections.sort(graph[i]);
        }

        bfs(1);

        System.out.println(count);
        br.close();
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 0;

        while(!queue.isEmpty()) {
            int node = queue.poll();

            for (int i : graph[node]) {
                if (visited[i] == -1) {
                    visited[i] = visited[node] + 1;
                    queue.add(i);
                    count++;
                }
            }
        }
    }
}
