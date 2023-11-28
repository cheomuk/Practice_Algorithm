package Baekjoon.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baekjoon2609 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        List<Integer> list = new ArrayList<>();
        int min = 0;
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            list.add(Integer.parseInt(arr[i]));
        }

        Collections.sort(list);
        min = getGCD(list.get(0), list.get(1));
        max = (list.get(0) * list.get(1)) / min;

        System.out.println(min);
        System.out.println(max);
        br.close();
    }

    public static int getGCD(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return getGCD(b, a % b);
        }
    }
}
