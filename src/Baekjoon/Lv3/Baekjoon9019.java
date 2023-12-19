package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon9019 {

    static boolean[] visited;
    static String[] commands;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String[] arr = br.readLine().split(" ");

            visited = new boolean[10000];
            commands = new String[10000];

            bfs(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        }

        System.out.println(sb);
        br.close();
    }

    private static void bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        Arrays.fill(commands, "");
        visited[start] = true;

        while (!queue.isEmpty() && !visited[end]) {
            int now = queue.poll();

            int D = (2 * now) % 10000;
            int S = now == 0 ? 9999 : now - 1;
            int L = (now % 1000) * 10 + now / 1000;
            int R = (now % 10) * 1000 + now / 10;

            if (!visited[D]) {
                queue.add(D);
                visited[D] = true;
                commands[D] = commands[now] + "D";
            }

            if (!visited[S]) {
                queue.add(S);
                visited[S] = true;
                commands[S] = commands[now] + "S";
            }

            if (!visited[L]) {
                queue.add(L);
                visited[L] = true;
                commands[L] = commands[now] + "L";
            }

            if (!visited[R]) {
                queue.add(R);
                visited[R] = true;
                commands[R] = commands[now] + "R";
            }
        }

        sb.append(commands[end]).append("\n");
    }
}
