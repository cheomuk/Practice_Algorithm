package Baekjoon.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon2312 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            for (int i = 2; i <= n; i++) {
                int cnt = 0;

                while (n % i == 0) {
                    n /= i;
                    cnt++;
                }

                if (cnt != 0) {
                    sb.append(i).append(' ').append(cnt).append('\n');
                }

                if (n == 0) {
                    break;
                }
            }
        }

        System.out.print(sb);
        br.close();
    }
}
