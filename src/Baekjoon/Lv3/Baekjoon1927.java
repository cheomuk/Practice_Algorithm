package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1927 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < num; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value == 0) {
                if (queue.isEmpty()) {
                    sb.append(0).append("\n");
                } else {
                    int index = queue.poll();
                    sb.append(index).append("\n");
                }
            } else {
                queue.add(value);
            }
        }

        System.out.println(sb);
        br.close();
    }
}
