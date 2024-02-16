package Baekjoon.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2231 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for (int i = 0; i < N; i++) {
            int n = i;
            int sum = 0;

            while (n != 0) {
                sum += n % 10;
                n /= 10;
            }

            if (sum + i == N) {
                result = i;
                break;
            }

        }

        System.out.println(result);
        br.close();
    }
}
