package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Baekjoon5525 {

    static int N, M;
    static int count = 0;

    public static void main(String[] args) throws IOException {     // 50% 성공 -> 최적화 필요
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        String[] arr = br.readLine().split("");
        Queue<String> queue = new LinkedList<>(Arrays.asList(arr));

        String sn = createSn();
        String str = "";
        String word = "I";

        while (!queue.isEmpty()) {
            if (queue.peek().equals(word) && str.equals("")) {
                str += queue.poll();
            } else if (!str.equals("")) {
                if (!queue.peek().equals(word)) {
                    String s = queue.poll();
                    str += s;
                    word = s;
                } else if (queue.peek().equals("I")) {
                    str = queue.poll();
                } else {
                    queue.poll();
                    str = "";
                    word = "I";
                }
            } else {
                queue.poll();
            }

            if (sn.equals(str)) {
                count++;
                str = str.substring(2);
            }
        }

        System.out.println(count);
        br.close();
    }

    private static String createSn() {
        char[] chars = new char[N * 2 + 1];
        chars[0] = 'I';

        for (int i = 1; i < N + 1; i++) {
            chars[i * 2 - 1] = 'O';
            chars[i * 2] = 'I';
        }

        return new String(chars);
    }
}
