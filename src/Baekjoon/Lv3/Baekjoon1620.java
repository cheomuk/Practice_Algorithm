package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Baekjoon1620 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] arr = br.readLine().split(" ");
        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();

        for (int i = 1; i <= Integer.parseInt(arr[0]); i++) {
            String s = br.readLine();
            map1.put(i, s);
            map2.put(s, i);
        }

        for (int i = 1; i <= Integer.parseInt(arr[1]); i++) {
            String s = br.readLine();
            if (map2.containsKey(s)) {
                sb.append(map2.get(s)).append("\n");
            } else {
                sb.append(map1.get(Integer.parseInt(s))).append("\n");
            }
        }

        System.out.println(sb);
        br.close();
    }
}
