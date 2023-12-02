package Baekjoon.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon11050 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] arr = br.readLine().split(" ");
        int num = (fibo(Integer.parseInt(arr[0]) - Integer.parseInt(arr[1])) * fibo(Integer.parseInt(arr[1])));

        if (num != 0) {
            int value = fibo(Integer.parseInt(arr[0])) / num;
            System.out.println(sb.append(value));
        } else {
            System.out.println(sb.append(1));
        }

        br.close();
    }

    public static int fibo(int num) {
        if (num <= 1) {
            return num;
        } else {
            return num * fibo(num - 1);
        }
    }
}
