package Baekjoon.Lv1;

import java.io.*;
import java.util.StringTokenizer;

public class Baekjoon10951 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String str = "";

        while ((str=br.readLine()) != null) {
            try {
                st = new StringTokenizer(str);
                bw.write(Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken()) + "\n");
            } catch (RuntimeException e) {
                e.printStackTrace();
            }

            bw.flush();
        }
    }
}
