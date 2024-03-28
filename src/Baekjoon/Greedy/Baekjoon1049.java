package Baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1049 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        int A, B, C;

        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);

        int set = 1000;
        int single = 1000;

        for (int i = 0; i < M; i++) {
            String[] arr1 = br.readLine().split(" ");
            set = Math.min(set, Integer.parseInt(arr1[1]));
            single = Math.min(single, Integer.parseInt(arr1[2]));
        }

        if (N % 6 == 0) {
            A = set * (N / 6);
        } else {
            A = set * ((N / 6) + 1);
        }

        B = (set * (N / 6)) + (single * (N % 6));
        C = single * N;

        int result = Math.min(A, Math.min(B, C));

        System.out.println(result);
        br.close();
    }
}
