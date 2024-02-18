package Baekjoon.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2292 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int count = 1;
        int range = 2;

        if (N == 1) {
            sb.append(1);
        } else {
            while (range <= N) {
                range = range + (6 * count);
                count++;
            }

            sb.append(count);
        }

        System.out.println(sb);
        br.close();
    }
}
