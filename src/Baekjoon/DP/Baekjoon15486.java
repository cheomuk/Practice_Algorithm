package Baekjoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Baekjoon15486 {

    static int[] dp;
    static HashMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());

        dp = new int[num + 1];
        map = new HashMap<>();

        for (int i = 0; i < num; i++) {
            String[] arr = br.readLine().split(" ");
            map.put(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
        }



        System.out.println(sb);
        br.close();
    }
}
