package Baekjoon.Math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon2200 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int minKeyPresses = 0;

        minKeyPresses += N + (N - 1);

        for (int i = N - 1; i >= 0; i--) {
            int coefficient = Integer.parseInt(st.nextToken());
            if (coefficient > 0) {
                int digitCount = String.valueOf(coefficient).length();

                if (i == 0) {
                    minKeyPresses += digitCount;
                } else {
                    if (coefficient > 1) {
                        minKeyPresses += digitCount + 1;
                    } else {
                        minKeyPresses += 1;
                    }

                    if (i > 1) {
                        minKeyPresses += i;
                    }
                }

                minKeyPresses += 1;
            }
        }

        minKeyPresses += 1;

        System.out.println(minKeyPresses);
        br.close();
    }
}

