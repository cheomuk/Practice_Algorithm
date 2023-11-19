package Lv1;

public class FirstSecretMap {
    int[] arr = new int[16];

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[][] map1 = new int[n][n];
        int[][] map2 = new int[n][n];

        for (int i = 0; i < n; i++) {
            DFS(arr1[i], n);
            map1[i] = arr;
            arr = new int[n];
        }

        for (int i = 0; i < n; i++) {
            DFS(arr2[i], n);
            map2[i] = arr;
            arr = new int[n];
        }

        for (int i = 0; i < n; i++) {
            String text = "";
            for (int j = 0; j < n; j++) {
                if (map1[i][j] == 1 || map2[i][j] == 1) {
                    text += "#";
                } else {
                    text += " ";
                }
            }
            answer[i] = text;
        }

        return answer;
    }

    public void DFS(int v, int n) {
        if (v == 0)
            return;

        n--;
        DFS(v / 2, n);
        arr[n] = (v % 2);
    }
}
