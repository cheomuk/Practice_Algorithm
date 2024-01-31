package Baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baekjoon2217 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < N; i++) {
            int K = Integer.parseInt(br.readLine());
            pq.add(K);
        }

        int maxWeight = 0;

        for (int i = 1; i <= N; i++) {
            int currWeight = pq.poll();
            int currMaxWeight = currWeight * i;

            maxWeight = Math.max(maxWeight, currMaxWeight);
        }

        System.out.println(maxWeight);
        br.close();
    }
}
