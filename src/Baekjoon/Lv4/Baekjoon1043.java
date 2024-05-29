package Baekjoon.Lv4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon1043 {

    static int N, M, count;
    static List<List<Integer>> list;
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        count = 0;

        list = new ArrayList<>();

        String[] known = br.readLine().split(" ");

        if (known.length != 1) {
            for (int i = 1; i < known.length; i++) {
                set.add(Integer.parseInt(known[i]));
            }
        }

        for (int i = 0; i < M; i++) {
            String[] arr = br.readLine().split(" ");
            list.add(new ArrayList<>());

            for (int j = 1; j < arr.length; j++) {
                list.get(i).add(Integer.parseInt(arr[j]));
            }
        }

        boolean updated = true;

        while (updated) {
            updated = false; // 업데이트가 없다고 가정함.
            for (int i = 0; i < M; i++) {
                for (int num : list.get(i)) {
                    if (set.contains(num)) {
                        if (set.addAll(list.get(i))) {
                            updated = true;
                        }

                        break;
                    }
                }

                // 업데이트가 있었다면 처음부터 다시 시작함.
                if (updated) {
                    break;
                }
            }
        }

        // 거짓에 선동당한 파티 수 집계
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < list.get(i).size(); j++) {
                if (set.contains(list.get(i).get(j))) {
                    break;
                }

                if (j == list.get(i).size() - 1) {
                    count++;
                }
            }
        }

        System.out.println(count);
        br.close();
    }
}
