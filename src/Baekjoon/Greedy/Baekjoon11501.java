package Baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon11501 {

    static int[] stocks;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(" ");

            stocks = new int[n];

            for (int j = 0; j < n; j++) {
                stocks[j] = Integer.parseInt(arr[j]);
            }

            sb.append(find(0)).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static long find(int max) {
        long count = 0;

        for (int i = stocks.length - 1; i >= 0; i--) {
            if (max < stocks[i]) {
                max = stocks[i];
            } else {
                count += max - stocks[i];
            }
        }

        return count;
    }
}
