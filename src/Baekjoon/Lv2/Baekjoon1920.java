package Baekjoon.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1920 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(br.readLine());
        String[] arr1 = br.readLine().split(" ");
        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < num1; i++) {
            hashSet.add(Integer.parseInt(arr1[i]));
        }

        int num2 = Integer.parseInt(br.readLine());
        String[] arr2 = br.readLine().split(" ");
        int[] numArr = new int[num2];

        for (int i = 0; i < num2; i++) {
            numArr[i] = Integer.parseInt(arr2[i]);
        }

        for (int i = 0; i < num2; i++) {
            if (hashSet.contains(numArr[i])) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }

        br.close();
    }
}
