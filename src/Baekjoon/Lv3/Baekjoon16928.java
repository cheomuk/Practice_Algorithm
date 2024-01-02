package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class Baekjoon16928 {

    static int N, M;
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] arr = br.readLine().split(" ");

        N = Integer.parseInt(arr[0]);
        M = Integer.parseInt(arr[1]);

        for (int i = 0; i < N + M; i++) {
            String[] arr2 = br.readLine().split(" ");
            map.put(Integer.parseInt(arr2[0]), Integer.parseInt(arr2[1]));
        }

        visited = new int[101];

        int count = bfs();
        sb.append(count).append("\n");

        System.out.println(sb);
        br.close();
    }

    private static int bfs() {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        visited[1] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            if (node == 100) {
                return visited[node];
            }

            for (int i = 1; i <= 6; i++) {
                int next = node + i;

                if (next > 100) {
                    continue;
                }

                if (map.containsKey(next)) {
                    next = map.get(next);
                }

                if (visited[next] == 0) {
                    visited[next] = visited[node] + 1;
                    queue.offer(next);
                }
            }
        }

        return -1;
    }
}
