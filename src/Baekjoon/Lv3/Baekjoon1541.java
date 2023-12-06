package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon1541 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder str = new StringBuilder();
        List<String> list = new ArrayList<>();

        for (char c : s.toCharArray()) {
            if (c == '+' || c == '-') {
                list.add(str.toString());
                list.add(String.valueOf(c));
                str = new StringBuilder();
            } else {
                str.append(c);  // 마지막 숫자가 저장되지 못하므로
            }
        }

        list.add(str.toString()); // for 문이 끝난 후 저장한다.
        int sum = 0;
        int minusSum = 0;
        boolean minus = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals("+")) {
                continue;
            } else if (list.get(i).equals("-")) {
                sum -= minusSum;
                minusSum = 0;
                minus = true;
            } else if (minus) {
                minusSum += Integer.parseInt(list.get(i));
            } else {
                sum += Integer.parseInt(list.get(i));
            }
        }

        System.out.println(sum - minusSum);
        br.close();
    }
}
