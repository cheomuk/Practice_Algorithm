package Baekjoon.Lv1;

import java.io.*;

public class Baekjoon11720 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split("");
        int sum = 0;

        if (arr.length != num) {
            throw new RuntimeException("Overflow!");
        }

        for (String s : arr) {
            sum += Integer.parseInt(s);
        }

        System.out.println(sum);
    }
}
