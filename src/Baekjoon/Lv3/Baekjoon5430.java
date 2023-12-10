package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baekjoon5430 {

    static StringBuilder sb = new StringBuilder();
    static boolean vector = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> deque;

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            deque = new ArrayDeque<>();
            vector = false;

            String[] strArr = br.readLine().split("");
            int index = Integer.parseInt(br.readLine());

            String input = br.readLine();
            String[] valueArr = input.substring(1, input.length() - 1).split(",");

            for (int j = 0; j < index; j++) {
                deque.add(Integer.parseInt(valueArr[j]));
            }

            if (calc(strArr, deque)) {
                continue;
            }

            printf(deque);
        }

        System.out.print(sb);
        br.close();
    }

    private static boolean calc(String[] strArr, Deque<Integer> deque) {
        for (String s : strArr) {
            if (s.equals("R")) {
                vector = !vector;
            } else {
                if (vector && !deque.isEmpty()) {
                    deque.pollLast();
                } else if (!vector && !deque.isEmpty()) {
                    deque.pollFirst();
                } else {
                    sb.append("error\n");;
                    return true;
                }
            }
        }

        return false;
    }

    private static void printf(Deque<Integer> deque) {
        sb.append("[");

        if (!deque.isEmpty()) {
            if (vector) {
                sb.append(deque.pollLast());
                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollLast());
                }
            } else {
                sb.append(deque.pollFirst());
                while (!deque.isEmpty()) {
                    sb.append(',').append(deque.pollFirst());
                }
            }
        }

        sb.append("]").append("\n");
    }
}
