package Baekjoon.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Baekjoon15650 {

    static int N, M;
    static StringBuilder sb = new StringBuilder();
    static boolean[] visited;
    static TreeSet<Integer> treeSet;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        N = Integer.parseInt(arr[0]);
        M = Integer.parseInt(arr[1]);

        visited = new boolean[N];
        treeSet = new TreeSet<>();

        dfs(0);

        System.out.println(sb);
        br.close();
    }

    private static void dfs(int depth) {

        if (depth == M) {
            for (int val : treeSet) {
                sb.append(val).append(' ');
            }

            sb.append('\n');
            return;
        }

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (treeSet.contains(i)) {
                    treeSet.pollFirst();
                }

                treeSet.add(i + 1);
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}
