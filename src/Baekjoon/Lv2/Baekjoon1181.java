package Baekjoon.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1181 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());
        List<Sort> arr = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            arr.add(new Sort(br.readLine()));
        }

        Collections.sort(arr);
        Set<Sort> sortedSet = new TreeSet<>(arr);

        for (Sort sort : sortedSet) {
            System.out.println(sort.str);
        }

        br.close();
    }
}

class Sort implements Comparable<Sort> {
    String str;

    public Sort(String data) {
        str = data;
    }

    @Override
    public int compareTo(Sort sort) {
        if (str.length() < sort.str.length()) {
            return -1;
        } else if (str.length() > sort.str.length()) {
            return 1;
        } else {
            return str.compareTo(sort.str);
        }
    }
}