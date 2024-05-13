package Baekjoon.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1024 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        while (true) {
            int min = N / L - ((L - 1) / 2);
            if (min < 0 || L > 100) {
                System.out.println(-1);
                break;
            }

            int sum = ((min * 2) + L - 1) * (L / 2);

            if (sum == N) {
                for (int i = 0; i < L; i++) {
                    System.out.print((min + i) + " ");
                }

                break;
            } else {
                L++;
            }
        }
    }
}
