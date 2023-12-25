package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baekjoon11286 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        PriorityQueue<HeapSort> pq = new PriorityQueue<>();

        for (int i = 1; i <= num; i++) {
            int value = Integer.parseInt(br.readLine());

            if (value == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    sb.append(pq.poll().value).append("\n");
                }
            } else {
                HeapSort sort = new HeapSort(Math.abs(value), value);
                pq.add(sort);
            }
        }

        System.out.println(sb);
        br.close();
    }
}

class HeapSort implements Comparable<HeapSort> {
    int abs;
    int value;

    public HeapSort(int num, int num2) {
        abs = num;
        value = num2;
    }

    @Override
    public int compareTo(HeapSort sort) {
        if (abs < sort.abs) {
            return -1;
        } else if (abs == sort.abs) {
            return value < sort.value ? -1 : 1;
        } else {
            return 1;
        }
    }
}
