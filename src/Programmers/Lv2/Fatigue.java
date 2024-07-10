package Programmers.Lv2;

public class Fatigue {
    private static int maxCount = 0;

    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(k, dungeons, 0, visited);
        return maxCount;
    }

    private void dfs(int k, int[][] dungeons, int count, boolean[] visited) {
        maxCount = Math.max(maxCount, count);

        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && k >= dungeons[i][0]) {
                visited[i] = true;
                dfs(k - dungeons[i][1], dungeons, count + 1, visited);
                visited[i] = false;
            }
        }
    }
}
