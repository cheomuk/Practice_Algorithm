package Baekjoon.Lv1;

import java.io.*;

public class Baekjoon10869 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split(" ");
        int A = Integer.parseInt(arr[0]);
        int B = Integer.parseInt(arr[1]);

        bw.write(A + B + "\n");
        bw.write(A - B + "\n");
        bw.write(A * B + "\n");
        bw.write(A / B + "\n");
        bw.write(A % B + "\n");

        br.close();
        bw.flush();
        bw.close();
    }
}
