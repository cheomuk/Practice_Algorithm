package Baekjoon.BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1325 {

    static List<ArrayList<Integer>> list;
    static int[] ans;
    static int n, m;
    static boolean[] visit;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = new int[n + 1];

        list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
        }

        for (int i = 1; i <= n; i++) {
            visit = new boolean[n + 1];
            bfs(i);
        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            max = Math.max(max, ans[i]);
        }

        for (int i = 1; i <= n; i++) {
            if (ans[i] == max) {
                System.out.print(i + " ");
            }
        }
    }
    private static void bfs(int i) {
        Queue<Integer> q = new LinkedList<>();

        visit[i] = true;
        q.add(i);

        while(!q.isEmpty()) {
            int node = q.poll();

            for (int next : list.get(node)) {
                if (!visit[next]) {
                    visit[next] = true;
                    ans[next]++;
                    q.add(next);
                }
            }
        }
    }
}
