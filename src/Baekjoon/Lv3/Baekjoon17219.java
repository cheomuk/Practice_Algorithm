package Baekjoon.Lv3;

import java.io.*;
import java.util.*;

public class Baekjoon17219 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String passwd = st.nextToken();
            map.put(site,passwd);
        }

        for (int i = 0; i < m; i++) {
            String site = br.readLine();
            sb.append(map.get(site)).append("\n");
        }

        System.out.print(sb);
    }
}
