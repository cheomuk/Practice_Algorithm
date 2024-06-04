package Programmers.Lv3;

import java.util.*;

public class Network {

    public static List<ArrayList<Integer>> list;
    public static boolean[] visited;
    public static int count;

    public int solution(int n, int[][] computers) {
        list = new ArrayList<>();

        for (int i = 0; i < computers.length; i++) {
            list.add(new ArrayList<>());
        }

        visited = new boolean[list.size()];
        count = 0;

        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers[i].length; j++) {
                if (computers[i][j] == 1) {
                    list.get(i).add(j);
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (!visited[i]) {
                bfs(i);
            }
        }

        return count;
    }

    public void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        visited[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int next : list.get(node)) {
                if (!visited[next]) {
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }

        count++;
    }
}
