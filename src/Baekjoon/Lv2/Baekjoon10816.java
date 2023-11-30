package Baekjoon.Lv2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baekjoon10816 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            list.add(Integer.parseInt(arr[i]));
        }

        Collections.sort(list);

        int num2 = Integer.parseInt(br.readLine());
        String[] arr2 = br.readLine().split(" ");

        for (int i = 0; i < num2; i++) {
            int target = Integer.parseInt(arr2[i]);
            int upper = upperBound(list, target);
            int lower = lowerBound(list, target);
            stringBuilder.append(upper - lower).append(" ");
        }

        System.out.println(stringBuilder);
        br.close();
    }

    public static int lowerBound(List<Integer> list, int target) {
        int lt = 0, rt = list.size();

        while (lt < rt) {
            int mid = (lt + rt) / 2;

            if (list.get(mid) < target) {
                lt = mid + 1;
            } else {
                rt = mid;
            }
        }

        return lt;
    }

    public static int upperBound(List<Integer> list, int target) {
        int lt = 0, rt = list.size();

        while (lt < rt) {
            int mid = (lt + rt) / 2;

            if (list.get(mid) <= target) {
                lt = mid + 1;
            } else {
                rt = mid;
            }
        }

        return lt;
    }
}
