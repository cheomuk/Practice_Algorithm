package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon5525 {

    public static void main(String[] args) throws IOException {     // DP로도 한 번 풀어보기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        String str = br.readLine();

        int count = 0;
        int index = 0;

        for (int i = 1; i < M - 1; i++) {
            if (str.startsWith("O", i) && str.startsWith("I", i + 1)) {
                index++;
                if (index == N) {
                    if (str.startsWith("I", i - (index * 2 - 1))) {
                        count++;
                    }

                    index--;
                }

                i++;
            } else {
                index = 0;
            }
        }

        System.out.println(count);
        br.close();
    }
}