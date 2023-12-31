package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon10026 {

    static String[][] graph;
    static boolean[][] visited;
    static int num = 0;
    static int count = 0;
    static int colorBlindnessCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        num = Integer.parseInt(br.readLine());

        graph = new String[num][num];
        visited = new boolean[num][num];

        for (int i = 0; i < num; i++) {
            String[] arr = br.readLine().split("");
            for (int j = 0; j < num; j++) {
                graph[i][j] = arr[j];
            }
        }

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (!visited[i][j]) {
                    find(j, i);
                }
            }
        }

        sb.append(count).append(" ");
        visited = new boolean[num][num];

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                if (!visited[i][j]) {
                    findColorBlindness(j, i);
                }
            }
        }

        sb.append(colorBlindnessCount);

        System.out.println(sb);
        br.close();
    }

    private static void find(int x, int y) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[y][x] = true;

        String color = graph[y][x];

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int xn = dx[i] + node[0];
                int yn = dy[i] + node[1];

                if (xn >= 0 && yn >= 0 && xn <= num - 1 && yn <= num - 1) {
                    if (!visited[yn][xn] && graph[yn][xn].equals(color)) {
                        queue.add(new int[]{xn, yn});
                        visited[yn][xn] = true;
                    }
                }
            }
        }

        count++;
    }

    private static void findColorBlindness(int x, int y) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[y][x] = true;

        String color = graph[y][x];

        while (!queue.isEmpty()) {
            int[] node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int xn = dx[i] + node[0];
                int yn = dy[i] + node[1];

                if (xn >= 0 && yn >= 0 && xn <= num - 1 && yn <= num - 1 && !visited[yn][xn]) {
                    if (graph[yn][xn].equals(color) && color.equals("B")) {
                        queue.add(new int[]{xn, yn});
                        visited[yn][xn] = true;
                    }

                    if ((color.equals("R") || color.equals("G"))
                            && (graph[yn][xn].equals("R") || graph[yn][xn].equals("G"))) {
                        queue.add(new int[]{xn, yn});
                        visited[yn][xn] = true;
                    }
                }
            }
        }

        colorBlindnessCount++;
    }
}
