package Baekjoon.Lv1;

import java.io.*;

public class Baekjoon10818 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        if (arr.length != num) {
            throw new RuntimeException("Wrong values.");
        }

        int min = Integer.parseInt(arr[0]);
        int max = Integer.parseInt(arr[0]);

        for (int i = 0; i < arr.length; i++) {
            if (Integer.parseInt(arr[i]) < min) {
                min = Integer.parseInt(arr[i]);
            }

            if (Integer.parseInt(arr[i]) > max) {
                max = Integer.parseInt(arr[i]);
            }
        }

        bw.write(min + " " + max);
        br.close();
        bw.flush();
        bw.close();
    }
}
