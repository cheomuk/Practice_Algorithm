package Baekjoon.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1259 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count;

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String str = br.readLine();
            count = 0;
            if (str.charAt(0) == '0') {
                break;
            }

            for (int j = 0; j < (str.length() / 2) + 1; j++) {
                if (str.charAt(j) != str.charAt(str.length() - j - 1)) {
                    break;
                } else {
                    count++;
                }
            }

            if (count == (str.length() / 2) + 1) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }

        br.close();
    }
}
