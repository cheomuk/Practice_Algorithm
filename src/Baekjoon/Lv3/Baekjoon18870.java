package Baekjoon.Lv3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Arrays;


public class Baekjoon18870 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int rank = 0;
        int N = Integer.parseInt(br.readLine());

        int[] origin = new int[N];
        int[] sorted = new int[N];

        HashMap<Integer, Integer> rankingMap = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            sorted[i] = origin[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sorted);

        for (int v : sorted) {
            if (!rankingMap.containsKey(v)) {
                rankingMap.put(v, rank);
                rank++;
            }
        }

        for (int key : origin) {
            int ranking = rankingMap.get(key);
            sb.append(ranking).append(' ');
        }

        System.out.println(sb);
    }
}
