package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon2805 {

    static int[] trees;
    static int min, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");

        int index = Integer.parseInt(arr[0]);
        int height = Integer.parseInt(arr[1]);

        trees = new int[index];
        min = 0;
        max = 0;

        String[] arr2 = br.readLine().split(" ");

        for (int i = 0; i < index; i++) {
            trees[i] = Integer.parseInt(arr2[i]);
            if (max < trees[i]) {
                max = trees[i];
            }
        }

        find(height);

        System.out.println(min - 1);
        br.close();
    }

    private static void find(int height) {
        while (min < max) {
            int mid = (max + min) / 2;
            long sum = 0;
            for (int tree : trees) {
                if (tree - mid > 0) {
                    sum += tree - mid;
                }
            }

            if (sum < height) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
    }
}
