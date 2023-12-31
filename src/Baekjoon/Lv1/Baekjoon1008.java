package Baekjoon.Lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1008 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        double value = 0.0f;

        if (Integer.parseInt(s[0]) > 0 && Integer.parseInt(s[1]) < 10) {
            value = (Double.parseDouble(s[0]) / Double.parseDouble(s[1]));
        }

        StringBuilder sb = new StringBuilder();
        sb.append(value);

        System.out.println(sb);
    }
}