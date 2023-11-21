package Baekjoon.Lv1;

import java.io.*;

public class Baekjoon2675 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < input[1].length(); j++) {
                bw.write((input[1].charAt(j) + "").repeat(Integer.parseInt(input[0])));
            }
            bw.write("\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}
