package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Baekjoon9375 {

    static HashMap<String, ArrayList<String>> map;
    static ArrayList<String> type;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        for (int i = 0; i < num; i++) {
            int num2 = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            type = new ArrayList<>();

            for (int j = 0; j < num2; j++) {
                String[] cloth = br.readLine().split(" ");
                if (map.containsKey(cloth[1])) {
                    ArrayList<String> existingValues = map.getOrDefault(cloth[1], new ArrayList<>());
                    existingValues.add(cloth[0]);
                    map.put(cloth[1], existingValues);
                } else {
                    ArrayList<String> newList = new ArrayList<>();
                    newList.add(cloth[0]);
                    type.add(cloth[1]);
                    map.put(cloth[1], newList);
                }
            }

            find();
        }

        System.out.println(sb);
        br.close();
    }

    private static void find() {
        int value = 1;

        for (int i = 0; i < type.size(); i++) {
            int n = map.get(type.get(i)).size();
            value *= (n + 1);
        }

        sb.append(value - 1).append("\n");
    }
}
