package Baekjoon.Lv1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1330 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        String value = "";

        if (Integer.parseInt(s[0]) > Integer.parseInt(s[1])) {
            value = ">";
        } else if (Integer.parseInt(s[0]) < Integer.parseInt(s[1])) {
            value = "<";
        } else {
            value = "==";
        }

        StringBuilder sb = new StringBuilder();
        sb.append(value);

        System.out.println(sb);
    }
}
