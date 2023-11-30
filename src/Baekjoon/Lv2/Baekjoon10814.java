package Baekjoon.Lv2;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baekjoon10814 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int num = Integer.parseInt(br.readLine());
        List<HashSort> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            String[] arr = br.readLine().split(" ");
            HashSort hashSort = new HashSort(Integer.parseInt(arr[0]), arr[1], i);
            list.add(hashSort);
        }

        Collections.sort(list);

        for (HashSort hashSort : list) {
            bw.write(hashSort.age + " " + hashSort.name + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}

class HashSort implements Comparable<HashSort> {

    int age;
    String name;
    int index;

    public HashSort(int num, String data, int num2) {
        age = num;
        name = data;
        index = num2;
    }

    @Override
    public int compareTo(HashSort sort) {
        if (age < sort.age) {
            return -1;
        } else if (age == sort.age) {
            return index < sort.index ? -1 : 1;
        } else {
            return 1;
        }
    }
}
