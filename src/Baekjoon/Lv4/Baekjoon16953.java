package Baekjoon.Lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon16953 {

    private static long a,b;
    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] arr = br.readLine().split(" ");

        a = Long.parseLong(arr[0]);
        b = Long.parseLong(arr[1]);

        sb.append(bfs());

        System.out.println(sb);
        br.close();
    }

    private static int bfs() {
        Queue<Long> q = new LinkedList<>();
        q.add(a);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                long tmp = q.poll();

                if (tmp == b) {
                    return count + 1;
                }

                if (tmp * 2 <= b) {
                    q.add(tmp*2);
                }

                if (tmp * 10 + 1 <= b) {
                    q.add(tmp * 10 + 1);
                }
            }

            count++;
        }

        return -1;
    }
}
