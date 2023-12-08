package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Baekjoon1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        HashSet<String> set = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();
        int count = 0;

        for (int i = 0; i < Integer.parseInt(arr[0]); i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < Integer.parseInt(arr[1]); i++) {
            String s = br.readLine();
            if (set.contains(s)) {
                count++;
                list.add(s);
            }
        }

        Collections.sort(list);
        System.out.println(count);

        for (String str : list) {
            System.out.println(str);
        }

        br.close();
    }
}
