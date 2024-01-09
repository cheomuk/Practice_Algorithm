package Baekjoon.BackTracking;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon1182 {

    static int[] graph;
    static int N, S;
    static int count = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] num = br.readLine().split(" ");
        String[] arr = br.readLine().split(" ");

        N = Integer.parseInt(num[0]);
        S = Integer.parseInt(num[1]);

        graph = new int[N + 1];

        for (int i = 0; i < N; i++) {
            graph[i] = Integer.parseInt(arr[i]);
        }

        find(0, 0);

        sb.append(count).append("\n");

        System.out.println(sb);
        br.close();
    }

    private static void find(int pick, int cnt) {
        if (pick == N) {
            return;
        } else {
            if (graph[pick] + cnt == S) {
                count++;
            }

            find(pick + 1, cnt);
            find(pick + 1, cnt + graph[pick]);
        }
    }
}
