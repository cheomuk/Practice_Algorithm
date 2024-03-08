package Baekjoon.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon1002 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            String[] arr = br.readLine().split(" ");

            int x1 = Integer.parseInt(arr[0]);
            int y1 = Integer.parseInt(arr[1]);
            int r1 = Integer.parseInt(arr[2]);

            int x2 = Integer.parseInt(arr[3]);
            int y2 = Integer.parseInt(arr[4]);
            int r2 = Integer.parseInt(arr[5]);

            System.out.println(tangent_point(x1, y1, r1, x2, y2, r2));
        }

    }

    public static int tangent_point(int x1, int y1, int r1, int x2, int y2, int r2) {

        int distance_pow = (int)(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        if (x1 == x2 && y1 == y2 && r1 == r2) {
            //중점이 같으면서 반지름도 같을 경우
            return -1;
        } else if (distance_pow > Math.pow(r1 + r2, 2)) {
            // 두 원의 반지름 합보다 중점간 거리가 더 길 때
            return 0;
        } else if (distance_pow < Math.pow(r2 - r1, 2)) {
            // 원 안에 원이 있으나 내접하지 않을 때
            return 0;
        } else if (distance_pow == Math.pow(r2 - r1, 2)) {
            // 내접할 때
            return 1;
        } else if (distance_pow == Math.pow(r1 + r2, 2)) {
            // 외접할 때
            return 1;
        } else {
            return 2;
        }
    }
}
