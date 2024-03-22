package Baekjoon.Lv4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Baekjoon1629 {

    public static long C;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] arr = br.readLine().split(" ");

        long A = Long.parseLong(arr[0]);
        long B = Long.parseLong(arr[1]);

        C = Long.parseLong(arr[2]);

        sb.append(find(A, B));

        System.out.println(sb);
        br.close();
    }

    private static long find (long value, long exponent) {

        if (exponent == 1) {
            return value % C;
        }

        long temp = find(value, exponent / 2);

        if (exponent % 2 == 1) {
            return (temp * temp % C) * value % C;
        }

        return temp * temp % C;
    }
}
