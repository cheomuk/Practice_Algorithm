package Baekjoon.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon2644 {

    static int N;
    static List<ArrayList<Integer>> graph;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        int length = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        sb.append(bfs(Integer.parseInt(arr[0]), Integer.parseInt(arr[1])));

        System.out.println(sb);
        br.close();
    }

    private static int bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        visit = new boolean[N + 1];
        visit[start] = true;

        int[] distance = new int[N + 1];

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int next : graph.get(node)) {
                if (!visit[next]) {
                    queue.add(next);
                    visit[next] = true;
                    distance[next] = distance[node] + 1;
                }

                if (next == end) {
                    return distance[next];
                }
            }
        }

        return -1;
    }
}
