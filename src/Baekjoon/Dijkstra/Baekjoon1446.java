package Baekjoon.Dijkstra;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1446 {

    static int N, M;
    static ArrayList<Sort> dist = new ArrayList<>();
    static int[] dp;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] arr = br.readLine().split(" ");

        N = Integer.parseInt(arr[0]);
        M = Integer.parseInt(arr[1]);

        dp = new int[M + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            String[] arr2 = br.readLine().split(" ");

            int x = Integer.parseInt(arr2[0]);
            int y = Integer.parseInt(arr2[1]);
            int range = Integer.parseInt(arr2[2]);

            dist.add(new Sort(x, y, range));
        }

        Collections.sort(dist);

        bfs();

        sb.append(dp[M]);

        System.out.println(sb);
        br.close();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        dp[0] = 0;

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (Sort sort : dist) {
                if (sort.x == x) {
                    int y = sort.y;
                    int range = sort.range;

                    if (y <= M && dp[y] > dp[x] + range) {
                        dp[y] = dp[x] + range;
                        queue.add(y);
                    }
                }
            }

            if (x + 1 <= M && dp[x + 1] > dp[x] + 1) {
                dp[x + 1] = dp[x] + 1;
                queue.add(x + 1);
            }
        }
    }
}

class Sort implements Comparable<Sort> {
    int x;
    int y;
    int range;

    public Sort(int num, int num2, int num3) {
        x = num;
        y = num2;
        range = num3;
    }

    @Override
    public int compareTo(Sort sort) {
        if (x < sort.x) {
            return -1;
        } else if (x == sort.x) {
            return y < sort.y ? -1 : 1;
        } else {
            return 1;
        }
    }
}
