package Baekjoon.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baekjoon2798 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int[] numArr = new int[arr.length];
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            numArr[i] = Integer.parseInt(arr[i]);
        }

        List<Integer> list = new ArrayList<>();
        String[] arr2 = br.readLine().split(" ");

        for (int i = 0; i < numArr[0]; i++) {
            list.add(Integer.parseInt(arr2[i]));
        }

        Collections.sort(list);

        for (int i = 0; i < list.size() - 2; i++) {
            for (int j = i + 1; j < list.size() - 1; j++) {
                for (int q = j + 1; q < list.size(); q++) {
                    if (list.get(i) + list.get(j) + list.get(q) <= numArr[1] &&
                            list.get(i) + list.get(j) + list.get(q) > sum) {
                        sum = list.get(i) + list.get(j) + list.get(q);
                    }
                }
            }
        }

        System.out.println(sum);

        br.close();
    }
}
