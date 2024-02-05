package Baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Baekjoon2212 {

    static int[] sensors;
    static Integer[] distances;
    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        if (K >= N) {
            System.out.println(0);
            return;
        }

        sensors = new int[N];
        distances = new Integer[N - 1];

        String[] arr = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(sensors);

        sb.append(find());

        System.out.println(sb);
        br.close();
    }

    private static int find() {

        int count = 0;

        for (int i = 0; i < N - 1; i++) {
            distances[i] = sensors[i + 1] - sensors[i];
        }

        Arrays.sort(distances, Collections.reverseOrder());

        for (int i = K - 1; i < N - 1; i++) {
            count += distances[i];
        }

        return count;
    }
}
