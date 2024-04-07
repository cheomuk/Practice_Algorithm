package Baekjoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1072 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        long X, Y;

        StringTokenizer st = new StringTokenizer(br.readLine());

        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());

        long Z = 100 * Y / X;

        if (Z >= 99) {
            sb.append("-1");
        } else {

            long start = 0;
            long end = 2000000000;

            while (start < end) {
                long mid = (start + end) / 2;
                long ret = 100 * (Y + mid) / (X + mid);

                if (ret> Z) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }

            sb.append(end);
        }

        System.out.println(sb);
        br.close();
    }
}
