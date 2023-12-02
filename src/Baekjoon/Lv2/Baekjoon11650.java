package Baekjoon.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baekjoon11650 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int num = Integer.parseInt(br.readLine());
        List<XYSort> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            String[] strArr = br.readLine().split(" ");
            XYSort xySort = new XYSort(Integer.parseInt(strArr[0]), Integer.parseInt(strArr[1]));
            list.add(xySort);
        }

        Collections.sort(list);

        for (XYSort xySort : list) {
            sb.append(xySort.x).append(" ").append(xySort.y).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}

class XYSort implements Comparable<XYSort> {
    int x;
    int y;

    public XYSort(int num, int num2) {
        x = num;
        y = num2;
    }

    @Override
    public int compareTo(XYSort sort) {
        if (x < sort.x) {
            return -1;
        } else if (x == sort.x) {
            return y < sort.y ? -1 : 1;
        } else {
            return 1;
        }
    }
}