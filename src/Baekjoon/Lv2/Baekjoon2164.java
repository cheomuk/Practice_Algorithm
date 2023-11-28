package Baekjoon.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon2164 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= num; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            queue.remove();
            if (queue.peek() != null) {
                int i = queue.poll();
                queue.add(i);
            }
        }

        System.out.println(queue.peek());
        br.close();
    }
}
