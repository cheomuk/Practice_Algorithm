package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon1697 {

    static int[] visited;
    static int start, end;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        start = Integer.parseInt(arr[0]);
        end = Integer.parseInt(arr[1]);

        visited = new int[100001];

        if (start == end) {
            System.out.println(0);
        } else {
            bfs(start);
        }

        br.close();
    }

    private static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next;
                if (i == 0) {
                    next = node + 1;
                } else if (i == 1) {
                    next = node - 1;
                } else {
                    next = node * 2;
                }

                if (next == end) {
                    System.out.println(visited[node]);
                    return;
                }

                if (next >= 0 && next < visited.length && visited[next] == 0) {
                    queue.add(next);
                    visited[next] = visited[node] + 1;
                }
            }
        }
    }
}
