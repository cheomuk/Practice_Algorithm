package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Baekjoon11047 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        int N = Integer.parseInt(arr[0]);
        int K = Integer.parseInt(arr[1]);

        int[] coinList = new int[N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            coinList[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N - 1; i >= 0; i--) {
            if (coinList[i] <= K) {
                count += (K / coinList[i]);
                K = K % coinList[i];
            }
        }

        System.out.println(count);
    }
}
