package Baekjoon.Lv2;

import java.io.*;

public class Baekjoon1018 {
    public static void main(String[] args) throws IOException { // 미완성

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] strArray = br.readLine().split(" ");
        Boolean[][] arr = new Boolean[strArray[0].length()][strArray[1].length()];
        Boolean[] arr1 = new Boolean[8];
        int count = 0;

        for (int i = 0; i < 8; i++) {
            String[] strArr = br.readLine().split("");
            for (int j = 0; j < 8; j++) {
                if ()
            }
        }

        for (int i = 0; i < strArray[0].length(); i++) {
            for (int j = 1; j <= strArray[1].length(); j++) {
                if (i == 0) {
                    if (arr[i][j].equals(arr[i][j - 1])) {
                        arr[i][j] = "B";
                        count++;
                    }
                } else if (i <= strArray[0].length() - 1) {
                    if (arr[i][j].equals(arr[i][j - 1]) || arr[i][j].equals(arr[i + 1][j])) {
                        arr[i][j] = "B";
                        count++;
                    }
                } else {
                    if (arr[i][j].equals(arr[i][j - 1])) {
                        arr[i][j] = "B";
                        count++;
                    }
                }
            }
        }
    }
}
