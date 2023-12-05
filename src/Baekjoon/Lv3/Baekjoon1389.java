package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1389 {

    static int N, M;
    static int count = 0;
    static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        List<Sort> list = new ArrayList<>();

        N = Integer.parseInt(arr[0]);
        M = Integer.parseInt(arr[1]);

        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().split(" ");
            int u = Integer.parseInt(s[0]);
            int v = Integer.parseInt(s[1]);

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    bfs(i, j);
                }
            }
            list.add(new Sort(i, count));
            count = 0;
        }

        Collections.sort(list);
        System.out.println(list.get(0).index);

        br.close();
    }

    private static void bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[N + 1]; // 각 정점까지의 최단 거리를 저장하는 배열
        Arrays.fill(distance, -1); // 초기값을 -1로 설정하여 방문하지 않은 상태로 초기화
        queue.add(start);
        distance[start] = 0; // 시작 정점까지의 거리는 0으로 설정

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int next : graph[node]) {
                if (distance[next] == -1) { // 아직 방문하지 않은 정점인 경우
                    queue.add(next);
                    distance[next] = distance[node] + 1; // 이전 정점까지의 거리 + 1을 저장
                }
            }
        }

        count += distance[end]; // 최단 거리를 count에 누적
    }
}

class Sort implements Comparable<Sort> {
    int index;
    int sum;

    public Sort(int num, int num2) {
        index = num;
        sum = num2;
    }

    @Override
    public int compareTo(Sort sort) {
        if (sum < sort.sum) {
            return -1;
        } else if (sum == sort.sum) {
            return index < sort.index ? -1 : 1;
        } else {
            return 1;
        }
    }
}