package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon11403 {

    static ArrayList<Integer>[] graph;
    static int[][] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException { // 미완성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        graph = new ArrayList[num];
        visited = new int[num][num];

        for (int i = 0; i < num; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < num; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < arr.length; j++) {
                if (Integer.parseInt(arr[j]) == 1) {
                    graph[i].add(j);
                    graph[j].add(i);
                }

                visited[i][j] = -1;
            }
        }

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (graph[i].get(j) == 1) {
                    bfs(j, i);
                }
            }
        }

        find(num);

        System.out.println(sb);
        br.close();
    }

    private static void bfs(int x, int y) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add();
        visited[y][x] = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();


        }
    }

    private static void find(int num) {
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (visited[i][j] == 1) {
                    sb.append(1).append(" ");
                } else {
                    sb.append(0).append(" ");
                }
            }

            sb.append("\n");
        }
    }
}
