package Baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Baekjoon10610 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] arr = br.readLine().split("");

        boolean checked = false;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("0")) {
                checked = true;
            }

            sum += Integer.parseInt(arr[i]);
        }

        if (checked && sum % 3 == 0) {
            sb.append(find(arr));
        } else {
            sb.append(-1);
        }

        System.out.println(sb);
        br.close();
    }

    private static String find(String[] arr) {
        Arrays.sort(arr, Collections.reverseOrder());
        String value = "";

        for (String str : arr) {
            value += str;
        }

        return value;
    }
}
