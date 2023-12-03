package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1074 {

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        int K = Integer.parseInt(arr[0]);
        int r = Integer.parseInt(arr[1]);
        int c = Integer.parseInt(arr[2]);

        find((int) Math.pow(2, K), r, c);

        System.out.println(count);
        br.close();
    }

    private static void find(int size, int r, int c) {
        if (size == 1) {
            return;
        }

        if (r < size / 2 && c < size / 2) {
            find(size / 2, r, c);
        } else if(r < size / 2 && c >= size / 2) {
            count += size * size / 4;
            find(size / 2, r, c - size / 2);
        }
        else if(r >= size / 2 && c < size / 2) {
            count += (size * size / 4) * 2;
            find(size / 2, r - size / 2, c);
        }
        else {
            count += (size * size / 4) * 3;
            find(size / 2, r - size / 2, c - size / 2);
        }
    }
}
