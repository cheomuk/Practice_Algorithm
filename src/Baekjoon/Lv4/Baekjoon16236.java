package Baekjoon.Lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baekjoon16236 {

    static int[][] graph;
    static int[][] visited;
    static int N;

    static class Shark implements Comparable<Shark> {
        int x;
        int y;
        int size;
        int range;
        int huntingCount;

        public Shark(int x, int y, int size, int range, int huntingCount) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.range = range;
            this.huntingCount = huntingCount;
        }

        @Override
        public int compareTo(Shark shark) {
            if (size < shark.size) {
                return -1;
            } else if (size == shark.size) {
                return y < shark.y ? -1 : 1;
            } else if (y == shark.y) {
                return x < shark.x ? -1 : 1;
            } else {
                return 1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        visited = new int[N][N];

        int[] babyShark = new int[2];

        for (int i = 0; i < N; i++) {
            String[] arr = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(arr[j]);
                visited[i][j] = -1;

                if (graph[i][j] == 9) {
                    babyShark = new int[] { j, i };
                }
            }
        }

        sb.append(bfs(babyShark[0], babyShark[1]));

        System.out.println(sb);
        br.close();
    }

    /*
        1. 아기 상어의 처음 크기는 2이다
        2. 아기 상어보다 큰 물고기 위치는 지나갈 수 없다.
        3. 아기 상어는 자기보다 작은 물고기만 먹을 수 있다.
        4. 자신의 크기와 같은 수의 물고기를 먹으면 크기가 +1 된다
        5. 크기가 늘어났음 스택은 초기화가 된다.
        6. 거리가 가장 가까운 물고기가 중복된다면 위쪽을, 그것도 겹친다면 왼쪽을 우선한다.
        7. 더 이상 먹을 수 없으면 종료한다.
     */

    private static int bfs(int x, int y) {
        int[] dx = { 0, 0, -1, 1 };
        int[] dy = { -1, 1, 0, 0 };

        PriorityQueue<Shark> pq = new PriorityQueue<>();
        pq.add(new Shark(x, y, 2, 0, 0));

        visited[y][x] = 0;
        int count = 0;
        int lastHuntingCount = 0;

        while (!pq.isEmpty()) {
            Shark node = pq.poll();

            for (int i = 0; i < 4; i++) {
                int xn = dx[i] + node.x;
                int yn = dy[i] + node.y;

                if (xn >= 0 && yn >= 0 && xn < N && yn < N && node.size <= graph[yn][xn]) {
                    if (node.size == node.huntingCount) {
                        node.size++;
                        node.huntingCount = 0;
                    }

                    if (graph[yn][xn] != 0 && graph[yn][xn] < node.size) {
                        pq.add(new Shark(xn, yn, node.size, 0, node.huntingCount + 1));
                        visited[yn][xn] = count + 1;
                        lastHuntingCount = visited[yn][xn];
                        continue;
                    }

                    if (graph[yn][xn] < node.size) {
                        if (visited[yn][xn] == -1) {
                            visited[yn][xn] = count + 1;
                        }

                        pq.add(new Shark(xn, yn, node.size, node.range + 1, node.huntingCount));
                    }
                }
            }

            count++;
        }

        return lastHuntingCount;
    }
}
