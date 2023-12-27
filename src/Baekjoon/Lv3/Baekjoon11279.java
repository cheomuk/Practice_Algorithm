package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baekjoon11279 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        PriorityQueue<MaxHeapSort> pq = new PriorityQueue<>();

        for (int i = 0; i < num; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll().value).append("\n");
                }
            } else {
                pq.add(new MaxHeapSort(value));
            }
        }

        System.out.println(sb);
        br.close();
    }
}

class MaxHeapSort implements Comparable<MaxHeapSort> {
    int value;

    public MaxHeapSort(int num) {
        value = num;
    }

    @Override
    public int compareTo(MaxHeapSort sort) {
        if (value <= sort.value) {
            return 1;
        } else {
            return -1;
        }
    }
}