package Baekjoon.Greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Baekjoon1946 {

    static class Grade implements Comparable<Grade> {
        int a;
        int b;

        Grade(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Grade o) {
            if(this.a > o.a) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine());
            ArrayList<Grade> list = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                String[] arr = br.readLine().split(" ");
                int a = Integer.parseInt(arr[0]);
                int b = Integer.parseInt(arr[1]);

                list.add(new Grade(a, b));
            }

            Collections.sort(list);

            int ans = 1;
            int min = list.get(0).b;

            for (int i = 1; i < N; i++) {
                if (list.get(i).b < min) {
                    ans++;
                    min = list.get(i).b;
                }
            }

            System.out.println(ans);
        }

        br.close();
    }
}
