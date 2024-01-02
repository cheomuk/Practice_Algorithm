package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon20529 {

    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            int num2 = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");

            arr = new String[num2];

            System.arraycopy(input, 0, arr, 0, num2);

            int value = find();
            sb.append(value).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static int find() {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int q = j + 1; q < arr.length; q++) {
                    int count = calc(arr[i], arr[j], arr[q]);
                    if (count == 0) {
                        return 0;
                    } else if (min > count) {
                        min = count;
                    }
                }
            }
        }

        return min;
    }

    private static int calc(String first, String second, String third) {
        int count = 0;

        if (first.equals(second) && second.equals(third)) {
            return 0;
        }

        for (int i = 0; i < 4; i++) {
            if (first.charAt(i) != second.charAt(i)) {
                count++;
            }

            if (second.charAt(i) != third.charAt(i)) {
                count++;
            }

            if (third.charAt(i) != first.charAt(i)) {
                count++;
            }
        }

        return count;
    }
}
