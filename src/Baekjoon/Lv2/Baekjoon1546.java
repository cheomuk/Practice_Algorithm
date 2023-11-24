package Baekjoon.Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baekjoon1546 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        if (arr.length != num) {
            throw new RuntimeException("Overflow!");
        }

        List<Float> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            list.add(Float.parseFloat(arr[i]));
        }

        Collections.sort(list);
        float average = calculate(list);

        System.out.println(average);
        br.close();
    }

    public static float calculate(List<Float> list) {
        float sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i) / list.get(list.size() - 1) * 100;
        }

        return sum / list.size();
    }
}
