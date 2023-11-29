package Baekjoon.Lv2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baekjoon4153 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            String[] arr = br.readLine().split(" ");
            List<Integer> list = new ArrayList<>();

            if (arr[0].equals("0") && arr[1].equals("0") && arr[2].equals("0")) {
                break;
            }

            for (String s : arr) {
                list.add(Integer.parseInt(s));
            }

            Collections.sort(list);

            if (Math.pow(list.get(0), 2) + Math.pow(list.get(1), 2) == Math.pow(list.get(2), 2)) {
                bw.write("right");
            } else {
                bw.write("wrong");
            }

            bw.newLine();
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
