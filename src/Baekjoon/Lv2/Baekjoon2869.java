package Baekjoon.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2869 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = br.readLine().split(" ");

        int A = Integer.parseInt(arr[0]);
        int B = Integer.parseInt(arr[1]);
        int V = Integer.parseInt(arr[2]);

        int value = (V - B) / (A - B);

        if ((V - B) % (A - B) != 0) {
            value++;
        }

        System.out.println(value);
        br.close();
    }
}
