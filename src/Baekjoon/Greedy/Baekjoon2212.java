package Baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baekjoon2212 {

    static int[] sensors;
    static int[] distances;
    static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        sensors = new int[N];
        distances = new int[N];

        String[] arr = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(arr[i]);
        }

        Arrays.sort(sensors);

        sb.append(find(0));

        System.out.println(sb);
        br.close();
    }

    private static int find(int count) {

    }
}
